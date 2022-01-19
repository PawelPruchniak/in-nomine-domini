package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;

import java.util.List;
import java.util.Optional;

public interface ExerciseLettersServiceIf {
    Iterable<ExerciseLetters> listAllExercisesLetters();

    Optional<ExerciseLetters> getExerciseLettersById( Long aId );

    ExerciseLetters saveExerciseLetters( ExerciseLetters aExerciseLetters );

    void deleteExerciseLetters( Long aId ) throws NotFoundException;

    Iterable<ExerciseLetters> getRandomExerciseLetters( List<Long> aLettersIds );
}
