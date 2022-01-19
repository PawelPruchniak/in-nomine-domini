package pl.edu.amu.home.paleografia.factory;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseSentencesFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseSentencesFactoryTest {

    @Test
    void factoryShouldCreateNotEmptyModel() {
        var exerciseSentencesList = ExerciseSentencesFactory.createModelForTesting();

        assertFalse( exerciseSentencesList.isEmpty() );
    }
}
