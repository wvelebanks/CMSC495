package javadb;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Justin
 */
public class JavaDB {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("javax.net.ssl.keyStore","C:/Users/Justin/Desktop/mysql/pk_certs/keystore");
            System.setProperty("javax.net.ssl.keyStorePassword","P@$$w0rd");
            System.setProperty("javax.net.ssl.trustStore","C:/Users/Justin/Desktop/mysql/pk_certs/truststore");
            System.setProperty("javax.net.ssl.trustStorePassword","P@$$w0rd");
        } 
        catch (ClassNotFoundException ex) {
        }
        
        Connection conn = null;
        String username = "root";
        String password = "password";
        String dbURL = "jdbc:mysql://localhost/mysql"
                + "?verifyServerCertificate=true"
                + "&clientCertificateKeyStoreUrl=file:///C:/Users/Justin/Desktop/mysql/pk_certs/keystore"
                + "&clientCertificateKeyStorePassword=P@$$w0rd"
                + "&useSSL=true"
                + "&requireSSL=true";
        
        try {
            conn =
            DriverManager.getConnection(dbURL, username, password);

            Statement stmt = null;
            ResultSet rs = null;
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT USER FROM USER");
                while(rs.next()) {
                    System.out.println(rs.getString(1));
                }
                
                // TEST THE SIGNING AND VERIFYING FEATURES
                sign("test");
                verifySignature("test");
                // END TEST
            }
            catch (SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { } // ignore

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { } // ignore

                    stmt = null;
                }
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public static byte[] hashTimesheet(String testString) {
        byte[] thehash = null;
        try{
            //String testString = "test";
            String key = "1234";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secretKey);
            thehash = sha256_HMAC.doFinal(testString.getBytes());
        } 
        catch (NoSuchAlgorithmException | InvalidKeyException e) {
            //handle the exception
        }
        return thehash;
    }
    
     private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
     
    public static KeyPair loadKey() {
        KeyPair kp = null;
        try{
            KeyStore ks = KeyStore.getInstance("JKS");
            InputStream readStream = new FileInputStream("C:/Users/Justin/Desktop/mysql/pk_certs/pk12_store/client.keystore");
            char[] pass_array = "P@$$w0rd".toCharArray();
            ks.load(readStream, pass_array);
            kp = getKeyPair(ks, "jrmullins", pass_array);
        }
        catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
        } 
        return kp;
    }
    
    //Got code from here: https://blogs.oracle.com/weblogic-config-runtime/entry/a_short_utility_program_to
    public static KeyPair getKeyPair(KeyStore keystore, String alias, char[] password) {
        try {
          // Get private key
          Key key = keystore.getKey(alias, password);
          if (key instanceof PrivateKey) {
            // Get certificate of public key
              java.security.cert.Certificate cert = keystore.getCertificate(alias);
            // Get public key
            PublicKey publicKey = cert.getPublicKey();
            // Return a key pair
            return new KeyPair(publicKey, (PrivateKey)key);
          }
        } 
        catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
        }
        return null;
    }
    
    // Motly taken from here: https://kodejava.org/how-to-create-a-digital-signature-and-sign-data/
    public static void sign(String signme) {
        try{
            // Get an instance of Signature object and initialize it.
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(loadKey().getPrivate());

            // Supply the data to be signed to the Signature object
            // using the update() method and generate the digital
            // signature.
            
            signature.update(hashTimesheet(signme));
            byte[] digitalSignature = signature.sign();
            
            // Save digital signature and the public key to a file (will need to save to database).
            Files.write(Paths.get("signature"), digitalSignature);
            Files.write(Paths.get("publickey"), loadKey().getPublic().getEncoded());
        }
        catch (IOException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
        }
    }
    
    // Mostly taken from here: https://kodejava.org/how-to-verify-digital-signature-of-a-signed-data/
    public static void verifySignature(String verifyme) {
        try {
            // WIll need to grab this from database instead of file
            byte[] publicKeyEncoded = Files.readAllBytes(Paths.get("publickey"));
            byte[] digitalSignature = Files.readAllBytes(Paths.get("signature"));

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);

            signature.update(hashTimesheet(verifyme));

            boolean verified = signature.verify(digitalSignature);
            if (verified) {
                System.out.println("Data verified.");
            } else {
                System.out.println("Cannot verify data.");
            }
        } 
        catch (IOException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e) {
        }
    }
}
