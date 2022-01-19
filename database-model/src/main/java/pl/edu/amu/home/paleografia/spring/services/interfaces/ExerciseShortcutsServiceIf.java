package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;

import java.util.Optional;

public interface ExerciseShortcutsServiceIf {
    Iterable<ExerciseShortcuts> listAllExercisesShortcuts();

    Optional<ExerciseShortcuts> getExerciseShortcutsById( Long aId );

    ExerciseShortcuts saveExerciseShortcuts( ExerciseShortcuts aExerciseShortcuts );

    void deleteExerciseShortcuts( Long aId ) throws NotFoundException;
}
