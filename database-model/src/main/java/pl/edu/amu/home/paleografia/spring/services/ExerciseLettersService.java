package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.repositories.ExerciseLettersRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseLettersServiceIf;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseLettersService implements ExerciseLettersServiceIf {

    @Autowired
    ExerciseLettersRepository exerciseLettersRepository;

    @Override
    public Iterable<ExerciseLetters> listAllExercisesLetters() {
        return exerciseLettersRepository.findAll();
    }

    @Override
    public Optional<ExerciseLetters> getExerciseLettersById( Long aId ) {
        return exerciseLettersRepository.findById( aId );
    }

    @Override
    public ExerciseLetters saveExerciseLetters( ExerciseLetters aExerciseLetters ) {
        return exerciseLettersRepository.save( aExerciseLetters );
    }

    @Override
    public void deleteExerciseLetters( Long aId ) throws NotFoundException {
        var exerciseLetters = exerciseLettersRepository.findById( aId );
        if ( exerciseLetters.isPresent() ) {
            exerciseLettersRepository.delete( exerciseLetters.get() );
        }
        else {
            throw new NotFoundException( "ExerciseGaps with id=" + aId + " do not exists" );
        }
    }

    @Override
    public Iterable<ExerciseLetters> getRandomExerciseLetters( List<Long> aLettersIds ) {
        List<ExerciseLetters> allExerciseLetters = exerciseLettersRepository.findAll();
        deleteExerciseLettersFromList( allExerciseLetters, aLettersIds );

        return allExerciseLetters;
    }

    private void deleteExerciseLettersFromList( List<ExerciseLetters> aExerciseLetters, List<Long> aLettersIds ) {
        aExerciseLetters.removeIf( exercise -> aLettersIds.contains( exercise.getId() ) );
    }
}
