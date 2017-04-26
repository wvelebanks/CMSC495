package etmsclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Properties;

/**
 *
 * @author Justin
 */
public class Helper {

    public static byte[] hashString(String timesheetString) {
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
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
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
        // Note: Chane filepath below for testing on your system
        // Figure out where to store files so we don't have to include the absolute path
        switch (config) {
            case 1:
                configuration = "D:\\Documents\\NetBeansProjects\\ETMS_Client\\etms.cfg";
                break;
            case 2:
                configuration = "D:\\Documents\\NetBeansProjects\\ETMS_Client\\cert.cfg";
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
    public static KeyPair loadKey(String keystorePath, String keystorePassword, String alias) {
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
}
