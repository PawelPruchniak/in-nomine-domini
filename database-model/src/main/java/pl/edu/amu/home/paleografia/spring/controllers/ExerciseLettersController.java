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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.exception.RestPreconditions;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseLettersServiceIf;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExerciseLettersController {
    @Autowired
    private ExerciseLettersServiceIf exerciseLettersService;

    /***
     * Getting all ExercisesLetters - GET API
     * @param aModel - Model of ExerciseLetters
     * @return List of all ExercisesLetters
     */
    @GetMapping(value = "/exercisesLetters", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ExerciseLetters> list( Model aModel ) {
        return exerciseLettersService.listAllExercisesLetters();
    }

    /***
     * Getting ExerciseLetters by Id - GET API
     * @param aId - Id of getted ExerciseLetters
     * @return one ExerciseLetters
     */
    @GetMapping(value = "/exerciseLetters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExerciseLetters getById( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( exerciseLettersService.getExerciseLettersById( aId ) );
    }

    /***
     * Getting random ExerciseLetters excluding one with Id - GET API
     * @param aLettersIds - Id of excluded ExerciseLetters
     * @return few ExerciseLetters
     */
    @GetMapping(value = "/exerciseLetters/random/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<ExerciseLetters> getRandomExerciseLetters(
            @PathVariable("id") List<Long> aLettersIds ) throws NotFoundException {
        return RestPreconditions.checkIfExists(
                Optional.of( exerciseLettersService.getRandomExerciseLetters( aLettersIds ) ) );
    }

}
