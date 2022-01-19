package pl.edu.amu.home.paleografia.security;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.spring.security.Encryption;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class EncryptionTest {

    private final Encryption encryption = new Encryption();
    private final Charset charset = StandardCharsets.UTF_8;

    @Test
    void shouldNotEncryptIfSimplePasswordIsWrong() {
        var passwordEncrypt = "hasło123".toCharArray();
        var passwordDecrypt = "haslo123".toCharArray();
        var dataToEncrypt = "some data to encrypt".getBytes( StandardCharsets.UTF_8 );

        var dataEncrypted = encryption.encrypt( dataToEncrypt, passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordDecrypt );

        assertNotNull( dataEncrypted );
        assertNull( dataDecrypted );
    }

    @Test
    void shouldNotEncryptIfPasswordIsWrong() {
        var passwordEncrypt = "eagwejkgba34Y a34y 4a3a wEAG 1RT1G1g!132G238465 ?h345 Q".toCharArray();
        var passwordDecrypt = "eagwejkgba34Y a34y 4a3a WEAG 1RT1G1g!132G238465 ?h345 Q".toCharArray();
        var dataToEncrypt = "some data to encrypt".getBytes( StandardCharsets.UTF_8 );

        var dataEncrypted = encryption.encrypt( dataToEncrypt, passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordDecrypt );

        assertNotNull( dataEncrypted );
        assertNull( dataDecrypted );
    }

    @Test
    void shouldEncryptIfSimplePasswordIsCorrect() {
        var passwordEncrypt = "hasło123".toCharArray();
        var dataToEncrypt = "some data to encrypt".getBytes( StandardCharsets.UTF_8 );

        var dataEncrypted = encryption.encrypt( dataToEncrypt, passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordEncrypt );

        assertNotNull( dataEncrypted );
        assertNotNull( dataDecrypted );
    }

    @Test
    void shouldEncryptIfPasswordIsCorrect() {
        var passwordEncrypt = "eagwejkgba34Y a34y 4a3a WEAG 1RT1G1g!132G238465 ?h345 Q".toCharArray();
        var dataToEncrypt = "some data to encrypt";

        var dataEncrypted = encryption.encrypt( dataToEncrypt.getBytes( StandardCharsets.UTF_8 ), passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordEncrypt );

        assertNotNull( dataEncrypted );
        assertNotNull( dataDecrypted );
    }

    @Test
    void simpleDataShouldBeEncryptedCorrectly() {
        var passwordEncrypt = "eagwejkgba34Y a34y 4a3a WEAG 1RT1G1g!132G238465 ?h345 Q".toCharArray();
        var dataToEncrypt = "simple data";

        var dataEncrypted = encryption.encrypt( dataToEncrypt.getBytes( StandardCharsets.UTF_8 ), passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordEncrypt );

        assertNotNull( dataEncrypted );
        assertNotNull( dataDecrypted );
        assertEquals( dataToEncrypt, charset
                .decode( ByteBuffer.wrap( dataDecrypted ) )
                .toString() );
    }


    @Test
    void dataShouldBeEncryptedCorrectly() {
        var passwordEncrypt = "eagwejkgba34Y a34y 4a3a WEAG 1RT1G1g!132G238465 ?h345 Q".toCharArray();
        var dataToEncrypt = "GEAWghawg34 has3 h3hws  3213 t11 1f11f f12a?agher g";

        var dataEncrypted = encryption.encrypt( dataToEncrypt.getBytes( StandardCharsets.UTF_8 ), passwordEncrypt );
        var dataDecrypted = encryption.decrypt( dataEncrypted, passwordEncrypt );

        assertNotNull( dataEncrypted );
        assertNotNull( dataDecrypted );
        assertEquals( dataToEncrypt, charset
                .decode( ByteBuffer.wrap( dataDecrypted ) )
                .toString() );
    }
}
