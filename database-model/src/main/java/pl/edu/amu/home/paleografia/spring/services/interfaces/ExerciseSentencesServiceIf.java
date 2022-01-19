package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;

import java.util.Optional;

public interface ExerciseSentencesServiceIf {
    Iterable<ExerciseSentences> listAllExercisesSentences();

    Optional<ExerciseSentences> getExerciseSentencesById( Long aId );

    ExerciseSentences saveExerciseSentences( ExerciseSentences aExerciseSentences );

    void deleteExerciseSentences( Long aId ) throws NotFoundException;

    Optional<ExerciseSentences> getRandomExerciseSentences( Long aId );
}
