package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.Image;
import pl.edu.amu.home.paleografia.spring.repositories.ImageRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ImageServiceIf;

import java.util.Optional;

@Service
public class ImageService implements ImageServiceIf {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Iterable<Image> listAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> getImageById( Long aId ) {
        return imageRepository.findById( aId );
    }

    @Override
    public Image saveImage( Image aImage ) {
        return imageRepository.save( aImage );
    }

    @Override
    public void deleteImage( Long aId ) throws NotFoundException {
        var image = imageRepository.findById( aId );
        if ( image.isPresent() ) {
            imageRepository.delete( image.get() );
        }
        else {
            throw new NotFoundException( "ExerciseGaps with id=" + aId + " do not exists" );
        }
    }
}
