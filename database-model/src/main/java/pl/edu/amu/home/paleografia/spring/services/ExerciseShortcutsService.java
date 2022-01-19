package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.repositories.ExerciseShortcutsRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseShortcutsServiceIf;

import java.util.Optional;

@Service
public class ExerciseShortcutsService implements ExerciseShortcutsServiceIf {

    @Autowired
    ExerciseShortcutsRepository exerciseShortcutsRepository;

    @Override
    public Iterable<ExerciseShortcuts> listAllExercisesShortcuts() {
        return exerciseShortcutsRepository.findAll();
    }

    @Override
    public Optional<ExerciseShortcuts> getExerciseShortcutsById( Long aId ) {
        return exerciseShortcutsRepository.findById( aId );
    }

    @Override
    public ExerciseShortcuts saveExerciseShortcuts( ExerciseShortcuts aExerciseShortcuts ) {
        return exerciseShortcutsRepository.save( aExerciseShortcuts );
    }

    @Override
    public void deleteExerciseShortcuts( Long aId ) throws NotFoundException {
        var exerciseShortcuts = exerciseShortcutsRepository.findById( aId );
        if ( exerciseShortcuts.isPresent() ) {
            exerciseShortcutsRepository.delete( exerciseShortcuts.get() );
        }
        else {
            throw new NotFoundException( "ExerciseGaps with id=" + aId + " do not exists" );
        }
    }
}
