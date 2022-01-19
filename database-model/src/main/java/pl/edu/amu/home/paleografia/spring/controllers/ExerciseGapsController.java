package pl.edu.amu.home.paleografia.spring.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.exception.RestPreconditions;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseGapsServiceIf;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExerciseGapsController {

    @Autowired
    private ExerciseGapsServiceIf exerciseGapsService;

    /***
     * Getting all ExercisesGaps - GET API
     * @param aModel - Model of ExerciseGaps
     * @return List of all ExercisesGaps
     */
    @GetMapping(value = "/exercisesGaps", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ExerciseGaps> list( Model aModel ) {
        return exerciseGapsService.listAllExercisesGaps();
    }

    /***
     * Getting ExerciseGaps by Id - GET API
     * @param aId - Id of getted ExerciseGaps
     * @return one ExerciseGaps
     */
    @GetMapping(value = "/exerciseGaps/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExerciseGaps getById( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( exerciseGapsService.getExerciseGapsById( aId ) );
    }

    /***
     * Getting ExerciseGaps by Difficulty Level - GET API
     * @param aDifficultyLevel - Difficulty Level of getted ExerciseGaps
     * @return List of ExercisesGaps with chosen difficulty level
     */
    @GetMapping(value = "/exerciseGaps/diff/{difficultyLevel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExerciseGaps> getByDifficultyLevel( @PathVariable("difficultyLevel") Integer aDifficultyLevel ) {
        return exerciseGapsService.getExerciseGapsByDifficultyLevel( aDifficultyLevel );
    }

}
