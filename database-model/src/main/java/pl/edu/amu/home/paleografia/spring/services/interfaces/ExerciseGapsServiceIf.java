package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;

import java.util.List;
import java.util.Optional;

public interface ExerciseGapsServiceIf {
    Iterable<ExerciseGaps> listAllExercisesGaps();

    Optional<ExerciseGaps> getExerciseGapsById( Long aId );

    ExerciseGaps saveExerciseGaps( ExerciseGaps aExerciseGaps );

    void deleteExerciseGaps( Long aId ) throws NotFoundException;

    List<ExerciseGaps> getExerciseGapsByDifficultyLevel( Integer aDifficultyLevel );
}
