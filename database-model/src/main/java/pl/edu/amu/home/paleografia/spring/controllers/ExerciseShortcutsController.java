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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.exception.RestPreconditions;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseShortcutsServiceIf;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ExerciseShortcutsController {

    @Autowired
    private ExerciseShortcutsServiceIf exerciseShortcutsService;

    /***
     * Getting all ExercisesShortcuts - GET API
     * @param aModel - Model of ExerciseShortcuts
     * @return List of all ExercisesShortcuts
     */
    @GetMapping(value = "/exercisesShortcuts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ExerciseShortcuts> list( Model aModel ) {
        return exerciseShortcutsService.listAllExercisesShortcuts();
    }

    /***
     * Getting ExerciseShortcuts by Id - GET API
     * @param aId - Id of getted ExerciseShortcuts
     * @return one ExerciseShortcuts
     */
    @GetMapping(value = "/exerciseShortcuts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExerciseShortcuts getById( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( exerciseShortcutsService.getExerciseShortcutsById( aId ) );
    }

}
