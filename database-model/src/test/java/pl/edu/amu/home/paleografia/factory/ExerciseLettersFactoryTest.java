package pl.edu.amu.home.paleografia.factory;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseLettersFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseLettersFactoryTest {

    @Test
    void factoryShouldCreateNotEmptyModel() {
        var exerciseLettersList = ExerciseLettersFactory.createModelForTesting();

        assertFalse( exerciseLettersList.isEmpty() );
    }
}
