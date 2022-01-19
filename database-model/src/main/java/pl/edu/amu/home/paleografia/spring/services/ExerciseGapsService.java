package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.repositories.ExerciseGapsRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseGapsServiceIf;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseGapsService implements ExerciseGapsServiceIf {

    @Autowired
    ExerciseGapsRepository exerciseGapsRepository;

    @Override
    public Iterable<ExerciseGaps> listAllExercisesGaps() {
        return exerciseGapsRepository.findAll();
    }

    @Override
    public Optional<ExerciseGaps> getExerciseGapsById( Long aId ) {
        return exerciseGapsRepository.findById( aId );
    }

    @Override
    public ExerciseGaps saveExerciseGaps( ExerciseGaps aExerciseGaps ) {
        return exerciseGapsRepository.save( aExerciseGaps );
    }

    @Override
    public void deleteExerciseGaps( Long aId ) throws NotFoundException {
        var exerciseGaps = exerciseGapsRepository.findById( aId );
        if ( exerciseGaps.isPresent() ) {
            exerciseGapsRepository.delete( exerciseGaps.get() );
        }
        else {
            throw new NotFoundException( "ExerciseGaps with id=" + aId + " do not exists" );
        }
    }

    @Override
    public List<ExerciseGaps> getExerciseGapsByDifficultyLevel( Integer aDifficultyLevel ) {
        return exerciseGapsRepository.findByDifficultyLevel( aDifficultyLevel );
    }
}
