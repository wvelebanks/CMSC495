package etmsclient;

import static etmsclient.Helper.hashString;
import static etmsclient.Helper.loadKey;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/**
 * The DigitalSignature class can be used to digitally sign a String, in this
 * case it will be a String representing an employee's timesheet.  It can also
 * be used to verify a digital signature.
 * 
 * @author Justin Mullins
 */
public class DigitalSignature {

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
    public static byte[] digitalSign(String signme, Properties certProp) {
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
            signature.update(hashString(signme));
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
    public static boolean digitalVerify(String verifyme, byte[] publicKeyEncoded, byte[] digitalSignature) {
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
            signature.update(hashString(verifyme));

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
