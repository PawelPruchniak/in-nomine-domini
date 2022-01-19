package pl.edu.amu.home.paleografia.hibernate.factory;

import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.Image;

public class ImageFactory {

    private ImageFactory() {
        // private constructor to hide public one
    }

    public static Image createDefaultForTests() {
        var image = new Image();
        image.setPath( DefaultString.PATH );
        image.setLightPath( DefaultString.LIGHT_PATH );
        return image;
    }
}
