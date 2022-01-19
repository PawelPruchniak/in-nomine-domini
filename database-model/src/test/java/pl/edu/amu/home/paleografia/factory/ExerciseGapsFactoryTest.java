package pl.edu.amu.home.paleografia.factory;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseGapsFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseGapsFactoryTest {

    @Test
    void factoryShouldCreateNotEmptyModel() {
        var exerciseGapsList = ExerciseGapsFactory.createModelForTesting();

        assertFalse( exerciseGapsList.isEmpty() );
    }
}
