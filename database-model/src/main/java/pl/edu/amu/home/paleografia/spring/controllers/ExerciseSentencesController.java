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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.exception.RestPreconditions;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseSentencesServiceIf;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExerciseSentencesController {

    @Autowired
    private ExerciseSentencesServiceIf exerciseSentencesService;

    /***
     * Getting all ExercisesSentences - GET API
     * @param aModel - Model of ExerciseSentences
     * @return List of all ExercisesSentences
     */
    @GetMapping(value = "/exercisesSentences", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ExerciseSentences> list( Model aModel ) {
        return exerciseSentencesService.listAllExercisesSentences();
    }

    /***
     * Getting ExerciseSentences by Id - GET API
     * @param aId - Id of getted ExerciseSentences
     * @return one ExerciseSentences
     */
    @GetMapping(value = "/exerciseSentences/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExerciseSentences getById( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( exerciseSentencesService.getExerciseSentencesById( aId ) );
    }

    /***
     * Getting random ExerciseSentences excluding one with Id - GET API
     * @param aId - Id of excluded ExerciseSentences
     * @return one ExerciseSentences
     */
    @GetMapping(value = "/exerciseSentences/random/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExerciseSentences getRandomExerciseSentences( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( exerciseSentencesService.getRandomExerciseSentences( aId ) );
    }

}
