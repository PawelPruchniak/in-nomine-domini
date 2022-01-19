package pl.edu.amu.home.paleografia.factory;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseShortcutsFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseShortcutsFactoryTest {

    @Test
    void factoryShouldCreateNotEmptyModel() {
        var exerciseShortcutsList = ExerciseShortcutsFactory.createModelForTesting();

        assertFalse( exerciseShortcutsList.isEmpty() );
    }
}
