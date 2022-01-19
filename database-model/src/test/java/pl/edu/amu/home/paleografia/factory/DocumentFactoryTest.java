package pl.edu.amu.home.paleografia.factory;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.hibernate.factory.DocumentFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class DocumentFactoryTest {

    @Test
    void factoryShouldCreateNotEmptyModel() {
        var documentList = DocumentFactory.createModelForTesting();

        assertFalse( documentList.isEmpty() );
    }
}
