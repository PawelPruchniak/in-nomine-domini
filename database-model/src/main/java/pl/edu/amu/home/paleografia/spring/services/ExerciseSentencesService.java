package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.repositories.ExerciseSentencesRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseSentencesServiceIf;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ExerciseSentencesService implements ExerciseSentencesServiceIf {

    @Autowired
    ExerciseSentencesRepository exerciseSentencesRepository;

    @Override
    public Iterable<ExerciseSentences> listAllExercisesSentences() {
        return exerciseSentencesRepository.findAll();
    }

    @Override
    public Optional<ExerciseSentences> getExerciseSentencesById( Long aId ) {
        return exerciseSentencesRepository.findById( aId );
    }

    @Override
    public ExerciseSentences saveExerciseSentences( ExerciseSentences aExerciseSentences ) {
        return exerciseSentencesRepository.save( aExerciseSentences );
    }

    @Override
    public void deleteExerciseSentences( Long aId ) throws NotFoundException {
        var exerciseSentences = exerciseSentencesRepository.findById( aId );
        if ( exerciseSentences.isPresent() ) {
            exerciseSentencesRepository.delete( exerciseSentences.get() );
        }
        else {
            throw new NotFoundException( "ExerciseGaps with id=" + aId + " do not exists" );
        }
    }

    @Override
    public Optional<ExerciseSentences> getRandomExerciseSentences( Long aId ) {
        List<ExerciseSentences> allExerciseSentences = exerciseSentencesRepository.findAll();
        deleteExerciseSentencesFromList( allExerciseSentences, aId );

        return pickRandomExerciseSentences( allExerciseSentences );
    }

    private Optional<ExerciseSentences> pickRandomExerciseSentences( List<ExerciseSentences> aExerciseSentences ) {
        Random rand = new Random();
        return Optional.ofNullable( aExerciseSentences.get( rand.nextInt( aExerciseSentences.size() ) ) );
    }

    private void deleteExerciseSentencesFromList( List<ExerciseSentences> aExerciseSentences, Long aId ) {
        aExerciseSentences.removeIf( exercise -> exercise
                .getId()
                .equals( aId ) );
    }
}
