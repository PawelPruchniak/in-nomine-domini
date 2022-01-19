package pl.edu.amu.home.paleografia.spring.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static pl.edu.amu.home.paleografia.spring.controllers.ImageController.UPLOAD_DIR;


public class FileUploadUtil {

    public static String saveFile( String aUploadDir, String aFileName,
                                   MultipartFile aMultipartFile ) throws IOException {
        Path uploadPath = Paths.get( aUploadDir );

        if ( ! Files.exists( uploadPath ) ) {
            Files.createDirectories( uploadPath );
        }

        try ( InputStream inputStream = aMultipartFile.getInputStream() ) {
            Path filePath = uploadPath.resolve( aFileName );
            if ( Files.exists( filePath ) ) {
                aFileName = RandomStringUtils.randomAlphanumeric( 5 ) + "_" + aFileName;
                filePath = uploadPath.resolve( aFileName );
            }
            Files.copy( inputStream, filePath, StandardCopyOption.REPLACE_EXISTING );
            return UPLOAD_DIR + aFileName;
        }
        catch ( IOException aException ) {
            throw new IOException( "Could not save image file: " + aFileName, aException );
        }
    }
}
