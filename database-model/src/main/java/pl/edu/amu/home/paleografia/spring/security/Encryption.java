package pl.edu.amu.home.paleografia.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Encryption {

    private static final String PBKDF2_ALGORITHM = "PBKDF2withHmacSHA512";
    private static final String CBC_ALGORITHM = "AES/CBC/PKCS5Padding";

    private static final String SALT = "salt";
    private static final String IV = "iv";
    private static final String ENCRYPTED = "encrypted";

    Logger logger = LoggerFactory.getLogger( Encryption.class );

    public final Map<String, byte[]> encrypt( byte[] aDataToEncrypt, char[] aPassword ) {
        Map<String, byte[]> encryptedData = new HashMap<>();

        try {
            // 1 | Salt generation
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[256];
            random.nextBytes( salt );

            // 2 | Creating PBKDF2 key
            PBEKeySpec pbeKeySpec = new PBEKeySpec( aPassword, salt, 64000, 256 );
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance( PBKDF2_ALGORITHM );
            SecretKey secretKey = secretKeyFactory.generateSecret( pbeKeySpec );
            byte[] secretKeyEncoded = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec( secretKeyEncoded, "AES" );

            // 3 | Generating Initialization Vector (IV)
            SecureRandom ivRandom = SecureRandom.getInstanceStrong();
            byte[] iv = new byte[16];
            ivRandom.nextBytes( iv );
            IvParameterSpec ivSpec = new IvParameterSpec( iv );

            // 4 | Encrypting
            Cipher cipher = Cipher.getInstance( CBC_ALGORITHM );
            cipher.init( Cipher.ENCRYPT_MODE, keySpec, ivSpec );
            byte[] encrypted = cipher.doFinal( aDataToEncrypt );

            // 5 | Saving salt, iv, encrypted data
            encryptedData.put( SALT, salt );
            encryptedData.put( IV, iv );
            encryptedData.put( ENCRYPTED, encrypted );

        }
        catch ( Exception aException ) {
            logger.error(
                    "There was error during encrypting: " + aException.getMessage() + " with stack trace: " + Arrays.toString(
                            aException.getStackTrace() ) );
        }

        return encryptedData;
    }

    public final byte[] decrypt( Map<String, byte[]> aEncryptedData, char[] aPassword ) {
        byte[] decryptedData = null;

        try {
            // 1 | Reading salt, iv, encrypted data
            byte[] salt = aEncryptedData.get( SALT );
            byte[] iv = aEncryptedData.get( IV );
            byte[] encrypted = aEncryptedData.get( ENCRYPTED );

            // 2 | Reading key PBKDF2 key from password
            PBEKeySpec pbKeySpec = new PBEKeySpec( aPassword, salt, 64000, 256 );
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance( PBKDF2_ALGORITHM );
            SecretKey secretKey = secretKeyFactory.generateSecret( pbKeySpec );
            byte[] secretKeyEncoded = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec( secretKeyEncoded, "AES" );

            // 3 | Decrypting
            Cipher cipher = Cipher.getInstance( CBC_ALGORITHM );
            @SuppressWarnings("java:S3329") // Because we just reading IV not creating one
            IvParameterSpec ivSpec = new IvParameterSpec( iv );
            cipher.init( Cipher.DECRYPT_MODE, keySpec, ivSpec );

            decryptedData = cipher.doFinal( encrypted );
        }
        catch ( Exception aException ) {
            logger.error(
                    "There was error during decrypting: " + aException.getMessage() + " with stack trace: " + Arrays.toString(
                            aException.getStackTrace() ) );
        }

        return decryptedData;
    }
}
