package etms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.management.Query;
/**
 * Employee's Time Management System
 *
 * @author Justin Mullins
 */
public class DBConnector {

    // The database connection to be used for any querries or updates
    Connection conn = dbConnect();

    /**
     * Connects a client to a MySQL server using the Connector/J driver. Only
     * connects to the database using SSL/TLS connection.
     *
     * @return a secure Connection to a MySQL database
     */
    public static Connection dbConnect() {
        //applicationProp a set of properties from the etms.cfg file to establish a db connection
        //TODO - loadConfig prly shouldn't take any paramiters
        Properties applicationProp = loadConfig(1);
        // the username to connect to the database with
        String username = applicationProp.getProperty("client_username");
        // the password to connect to the database with
        String password = applicationProp.getProperty("client_password");
        // the database server to connect to
        String server = applicationProp.getProperty("server_address");
        // the path to the keystore
        String keystorePath = applicationProp.getProperty("keystore_path");
        // the password used to protect the keystore
        String keystorePassword = applicationProp.getProperty("keystore_password");
        // the path to the truststore
        String truststorePath = applicationProp.getProperty("truststore_path");
        // the password used to protect the truststore
        String truststorePassword = applicationProp.getProperty("truststore_password");
        // Set the database to be used
        String database = "test";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // The below four lines should have parameters that are read-in to set the paths and passwords
            
            System.setProperty("javax.net.ssl.keyStore", keystorePath);
            System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
            System.setProperty("javax.net.ssl.trustStore", truststorePath);
            System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);
        } catch (ClassNotFoundException ex) {
            // handle any errors
        }

        Connection newConn = null;
        String dbURL = "jdbc:mysql://" + server + "/" + database
                + "?verifyServerCertificate=true"
                + "&useSSL=true"
                + "&requireSSL=true";
        try {
            newConn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return newConn;
    }

    /**
     * Loads the "etms.cfg" or "cert.cfg" file from the same path where the
     * program is located. The etms.cfg file contains information critical to
     * setup a secure database connection from the client to the server, while
     * the "cert.cfg" file contains certificate/key information necessary to
     * sign files.
     *
     * @param config specify if you want 1, etms.cfg, or 2, cert.cfg
     * @return a Properties stream containing the client configuration from
     * etms.cfg or cert.cfg
     */
    public static Properties loadConfig(int config) {
        Properties applicationProps = new Properties();
        String configuration = "";

        switch (config) {
            case 1:
                configuration = "etms.cfg";
                break;
            case 2:
                configuration = "cert.cfg";
                break;
            // TODO: throw some error
            default:
                break;
        }

        try (FileInputStream in = new FileInputStream(configuration)) {
            applicationProps.load(in);
        } catch (FileNotFoundException ex) {
            // handle exception
        } catch (IOException ex) {
            // handle exception
        }
        return applicationProps;
    }

    
    public static void push (Query query)    { 
        Query pushQuery = new Query();
    }
    
    public static Query pull (Query query)    { 
        Query pullQuery = new Query();
        return pullQuery;
    }
    
    /**
     * Load a timesheet from the database based on the pay period date which is
     * passed in as a parameter. This should be able to be passed to the web GUI
     * timesheet to load in data, or to the digitalSign(String) and
     * digitalVerify(String) functions.
     *
     * @param conn the connection to the database
     * @param payperiodDate date for the payperiod in yyyymmdd format
     * @return a String that contains all the fields for timesheet
     */
    public String loadTimesheet(Connection conn, int payperiodDate) {
        String test = null;
        return test;
    }

    /**
     * Save the data in the web GUI timesheet to the database.
     *
     * @param conn the connection to the database
     */
    public void saveTimesheet(Connection conn) {
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
    public boolean verifyTimesheet() {
        boolean test = false;
        return test;
    }

    /**
     * Insert the digital signature for the users timesheet into the the
     * Signature table.
     *
     * @param conn a secure connection to the database server
     * @param employeeType set to 1 if saving the employee signature, set to 2
     * if saving the supervisor signature.
     * @param digitalSig the digital signature that is to be inserted into the
     * db
     * @param signatureId the primary key for the signature table in the etms db
     */
    public void saveSignature(Connection conn, int employeeType, byte[] digitalSig, int signatureId) {
        try {
            String employee = null;

            switch (employeeType) {
                case 1:
                    employee = "SignatureEmployee";
                    break;
                case 2:
                    employee = "SignatureSupervisor";
                    break;
                /* TODO: Throw some error */
                default:
                    break;
            }

            String insertSignature = "UPDATE signature SET " + employee + " = ? where SignatureID = ?";

            try (PreparedStatement ps = conn.prepareStatement(insertSignature)) {
                ps.setBytes(1, digitalSig);
                ps.setInt(2, signatureId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            // handle any errors
        }
    }

    /**
     * Load the digital signature from the database and return it to be
     * inspected. Identifies the signature to load based on the signatureId and
     * employeeType passed in. Digital signatures are stored in the etms
     * database under the signature table which has the following columns
     * (signatureId, SignatureEmployee, and SignatureSupervisor).
     *
     * @param conn a secure connection to the database server
     * @param employeeType specifies if the user is a supervisor or not (1 is
     * non-supervisor, 2 is supervisor)
     * @param signatureId the signature id of the row in the signature table
     * where the signature is stored.
     * @return the digital signature stored by the user of type employeeType in
     * the signature table in row signatureId.
     */
    public byte[] loadSignature(Connection conn, int employeeType, int signatureId) {
        String employee = null;
        byte[] signature = null;

        switch (employeeType) {
            case 1:
                employee = "SignatureEmployee";
                break;
            case 2:
                employee = "SignatureSupervisor";
                break;
            /* TODO: Throw some error */
            default:
                break;
        }

        String grabSignature = "SELECT " + employee + " from signature where signatureID = ?";

        try (PreparedStatement ps = conn.prepareStatement(grabSignature)) {
            ps.setInt(1, signatureId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            signature = rs.getBytes(employee);
        } catch (SQLException ex) {
        }
        return signature;
    }

    /**
     * Returns a hash of the String parameter provided in a byte array. This
     * function uses the SHA-256 hashing algorithm to do a one-way hash of the
     * string.
     *
     * @param timesheetString a String that is to be hashed
     * @return an array of bytes that represent the hash of hashString
     */
    public byte[] hashTimesheet(String timesheetString) {
        byte[] thehash = null;
        try {
            // Setup the hashing algorthim to be used
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Generate the hash byte array and set thehash equal to it
            thehash = md.digest(timesheetString.getBytes());
        } catch (NoSuchAlgorithmException e) {
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
    private String bytesToHex(byte[] bytes) {
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
     * @param keystorePath a String path to the keystore
     * @param keystorePassword a String that provides the password for the
     * keystore
     * @param alias the user who's certificate/keys we want to pull from the
     * keystore
     * @return a KeyPair which contains both a public and a private key
     */
    public KeyPair loadKey(String keystorePath, String keystorePassword, String alias) {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            InputStream readStream = new FileInputStream(keystorePath);
            char[] pass_array = keystorePassword.toCharArray();
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
     * @param certProp a set of Properties from the "cert.cfg" file to sign data
     * @return the digital signature of the string passed in
     */
    public byte[] digitalSign(String signme, Properties certProp) {
        try {
            // the path to the keystore
            String keystorePath = certProp.getProperty("keystore_path");
            // the password used to protect the keystore
            String keystorePassword = certProp.getProperty("keystore_password");
            // the path to the truststore
            String alias = certProp.getProperty("alias");

            // Setup the hashing algorithm to be used
            Signature signature = Signature.getInstance("SHA256withRSA");
            // Initialize the signature using a private key
            signature.initSign(loadKey(keystorePath, keystorePassword, alias).getPrivate());

            // Supply the data to be signed to the Signature object
            // using the update() method and generate the digital
            // signature.
            signature.update(hashTimesheet(signme));
            // The digital signature in byte array format
            byte[] digitalSignature = signature.sign();

            return digitalSignature;
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            // handle any errors
        }
        return null;
    }

    /**
     * Verifies if the content containing the digital signature was from the
     * user who's public key is used to decrypt the signature and that the
     * content was not tampered with since the user signed it.
     * <p>
     * Mostly taken from here:
     * https://kodejava.org/how-to-verify-digital-signature-of-a-signed-data/
     *
     * @param verifyme the String content that is to be verified
     * @param publicKeyEncoded the public key in an encoded format as a byte
     * array, this is used to decrypt the digital signature
     * @param digitalSignature the digital signature as a byte array that is to
     * be, verified.
     * @return true if the digital signature was verified, false if it was not
     * or could not be verified
     */
    public boolean digitalVerify(String verifyme, byte[] publicKeyEncoded, byte[] digitalSignature) {
        try {
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
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e) {
        }
        return false;
    }
}
