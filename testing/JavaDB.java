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
 * Proof of concept code I've worked on.
 *
 * @author Justin Mullins
 */
public class JavaDB {

    /**
     * Main function that executes the ETMS client.
     * <p>
     * DB Query example from:
     * https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-statements.html
     *
     * @param args
     */
    public static void main(String[] args) {
        // The database connection to be used for any querries or updates
        Connection conn = dbConnect();
        // Statement objects allow you to execute basic SQL queries
        Statement stmt = null;
        // ResultSet objects retrieve the results from the Statement objects
        ResultSet rs = null;

        try {
            // Create a Statement instance
            stmt = conn.createStatement();
            // executeQuery(String) allows you to do a SELECT query
            // executeUpdate(String) allows you to do a UPDATE, INSERT, or DELETE statement
            rs = stmt.executeQuery("SELECT USER FROM USER");
            // Loop through the ResultSet and print out results
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // TEST THE SIGNING AND VERIFYING FEATURES
            // digitally sign the string "test"
            digitalSign("test");
            // verify the digital signature
            digitalVerify("test");
            // END TEST

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // it is a good idea to release resources in a finally{} block
            // in reverse-order of their creation if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }

                stmt = null;
            }
        }
    }

    /**
     * Connects a client to a MySQL server using the Connector/J driver. Only
     * connects to the database using SSL/TLS connection. NOTE: Need to add
     * parameters for username, password, MySQL server address, MySQL table,
     * path to certificate truststore, truststore password,
     * clientCertificateKeyStoreUrl, and clientCertifcateKeyStorePassword.
     *
     * @return a secure Connection to a MySQL database
     */
    public static Connection dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.setProperty("javax.net.ssl.keyStore", "C:/Users/Justin/Desktop/mysql/pk_certs/keystore");
            System.setProperty("javax.net.ssl.keyStorePassword", "P@$$w0rd");
            System.setProperty("javax.net.ssl.trustStore", "C:/Users/Justin/Desktop/mysql/pk_certs/truststore");
            System.setProperty("javax.net.ssl.trustStorePassword", "P@$$w0rd");
        } catch (ClassNotFoundException ex) {
        }

        Connection conn = null;
        String username = "root";
        String password = "P@$$w0rd#787!$";
        String dbURL = "jdbc:mysql://localhost/mysql"
                + "?verifyServerCertificate=true"
                + "&clientCertificateKeyStoreUrl=file:///C:/Users/Justin/Desktop/mysql/pk_certs/keystore"
                + "&clientCertificateKeyStorePassword=P@$$w0rd"
                + "&useSSL=true"
                + "&requireSSL=true";

        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    /**
     * Load a timesheet from the database based on the pay period date which is
     * passed in as a parameter. This should be able to be passed to the web GUI
     * timesheet to load in data, or to the digitalSign(String) and
     * digitalVerify(String) functions.
     *
     * @param payperiodDate date for the payperiod in yyyymmdd format
     * @return a String that contains all the fields for timesheet
     */
    public static String loadTimesheet(int payperiodDate) {
        String test = null;
        return test;
    }

    /**
     * Save the data in the web GUI timesheet to the database.
     */
    public static void saveTimesheet() {
        // First verify if the data in the web GUI timesheet is valid
        verifyTimesheet();

        // Save the data back into the database
    }

    /**
     * Verify if the data entered in the web GUI timesheet is valid before
     * saving to the database.
     *
     * @return true if timesheet validates, false otherwise
     */
    public static boolean verifyTimesheet() {
        boolean test = false;
        return test;
    }

    /**
     * Returns a hash of the String parameter provided in a byte array. This
     * function uses the HMAC SHA256 hashing algorithm to do a one-way hash of
     * the string. A hard-coded secret key is used as part of this hashing
     * function.
     *
     * @param timesheetString a String that is to be hashed
     * @return an array of bytes that represent the hash of hashString
     */
    public static byte[] hashTimesheet(String timesheetString) {
        byte[] thehash = null;
        try {
            String key = "1234";

            // Setup the hashing algorthim to be used
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            // Create the secretKey
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            // Initialize the hashing algorithm using the secretKey
            sha256_HMAC.init(secretKey);
            // Hash the timesheetString parameter
            thehash = sha256_HMAC.doFinal(timesheetString.getBytes());
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            //handle the exception
        }
        return thehash;
    }

    /**
     * Helper function to assist in verifying the hashing function,
     * hashTimesheet(String). This function takes in a byte array of a hash and
     * converts it to hexadecimal format, which is the traditional hash output
     * format.
     *
     * @return a String that shows the hex of a hash
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    /**
     * Loads a KeyPair from a KeyStore NOTE: Need to pass in parameters for the
     * FileInputStream, password array, and user alias
     * <p>
     * Got code from here:
     * https://blogs.oracle.com/weblogic-config-runtime/entry/a_short_utility_program_to
     *
     * @return a KeyPair which contains both a public and a private key
     */
    public static KeyPair loadKey() {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            InputStream readStream = new FileInputStream("C:/Users/Justin/Desktop/mysql/pk_certs/pk12_store/client.keystore");
            char[] pass_array = "P@$$w0rd".toCharArray();
            String alias = "jrmullins";
            ks.load(readStream, pass_array);

            // Get private key
            Key key = ks.getKey(alias, pass_array);
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                java.security.cert.Certificate cert = ks.getCertificate(alias);
                // Get public key
                PublicKey publicKey = cert.getPublicKey();
                // Return a key pair
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException e) {
        }
        return null;
    }

    /**
     * Returns a digital signature of the String parameter that is passed in. A
     * digital signature is a hash of some content that has been encrypted using
     * a private key. This digital signature verifies the contents are from the
     * user because only their public key can decrypt the content and the hash
     * should match the the hash of the content received confirming the data has
     * not been modified since the user sent it.
     * <p>
     * This function uses the SHA256withRSA algorithm and the private key
     * provided from the loadKey() function.
     *
     * Mostly taken from here:
     * https://kodejava.org/how-to-create-a-digital-signature-and-sign-data/
     *
     * @param signme the String content that is to be digitally signed
     */
    public static void digitalSign(String signme) {
        try {
            // Setup the hashing algorithm to be used
            Signature signature = Signature.getInstance("SHA256withRSA");
            // Initialize the signature using a private key
            signature.initSign(loadKey().getPrivate());

            // Supply the data to be signed to the Signature object
            // using the update() method and generate the digital
            // signature.
            signature.update(hashTimesheet(signme));
            // The digital signature in byte array format
            byte[] digitalSignature = signature.sign();

            // Save digital signature and the public key to a file (will need to save to database)
            Files.write(Paths.get("signature"), digitalSignature);
            Files.write(Paths.get("publickey"), loadKey().getPublic().getEncoded());
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
        }
    }

    /**
     * Verifies if the content containing the digital signature was from the
     * user who's public key is used to decrypt the signature and that the
     * content was not tampered with since the user signed it. NOTE: Need to add
     * parameters for the publicKeyEncoded and digitalSignature
     * <p>
     * Mostly taken from here:
     * https://kodejava.org/how-to-verify-digital-signature-of-a-signed-data/
     *
     * @param verifyme the String content that is to be verified
     * @return true if the digital signature was verified, false if it was not
     * or could not be verified
     */
    public static boolean digitalVerify(String verifyme) {
        try {
            // Will need to grab this from database instead of file
            // Reads-in the byte array for the encoded public key
            byte[] publicKeyEncoded = Files.readAllBytes(Paths.get("publickey"));
            // Reads-in the byte array for the digital signature
            byte[] digitalSignature = Files.readAllBytes(Paths.get("signature"));

            // Use the encouded public key to create the X509EncodedKeySpec
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
            // Create the keyFactory that will be used to generate the public key
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // Generates the public key based on the publicKeySpec
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            // Setup the signature to use SHA256withRSA
            Signature signature = Signature.getInstance("SHA256withRSA");
            // Initialize the signature with the public key
            signature.initVerify(publicKey);

            // Supply the data to be signed to the Signature object
            // using the update() method and generate the digital
            // signature.
            signature.update(hashTimesheet(verifyme));

            // If the digital signature is verifed it will be set to true, otherwise false
            boolean verified = signature.verify(digitalSignature);
            if (verified) {
                System.out.println("Data verified.");
            } else {
                System.out.println("Cannot verify data.");
            }
            return verified;
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e) {
        }
        return false;
    }
}
