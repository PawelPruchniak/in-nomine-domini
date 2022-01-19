package pl.edu.amu.home.paleografia.spring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.amu.home.paleografia.spring.util.FileUploadUtil;

import java.io.IOException;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/security")
public class ImageController {

    @Value("${upload.path}")
    private String uploadPath;

    public static final String UPLOAD_DIR = "/uploads/";

    @PostMapping("/image")
    public ResponseEntity<String> saveImage( @RequestParam("image") MultipartFile aMultipartFile ) throws IOException {
        String fileName = StringUtils.cleanPath( Objects.requireNonNull( aMultipartFile.getOriginalFilename() ) );
        String savedPath = FileUploadUtil.saveFile( uploadPath, fileName, aMultipartFile );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( savedPath );
    }
}
