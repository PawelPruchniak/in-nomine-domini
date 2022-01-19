package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.Optional;

public interface ImageServiceIf {

    Iterable<Image> listAllImages();

    Optional<Image> getImageById( Long aId );

    Image saveImage( Image aImage );

    void deleteImage( Long aId ) throws NotFoundException;

}
