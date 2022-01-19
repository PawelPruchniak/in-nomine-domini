package pl.edu.amu.home.paleografia.spring.templates;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseShortcutsServiceIf;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Template(title = "Shortcuts manager", id = "paleografia/exercise_shortcuts")
@Controller
@RequestMapping("/security")
public class ExerciseShortcutsTemplate {

    @Autowired
    private ExerciseShortcutsServiceIf exerciseShortcutsService;

    /***
     * Create ExerciseShortcuts - POST API
     * @param aExerciseShortcuts - created ExerciseShortcuts
     * @return Http Response
     */
    @PostMapping(value = "/exerciseShortcuts")
    public ResponseEntity<ExerciseShortcuts> create(
            @RequestBody @Valid @NotNull ExerciseShortcuts aExerciseShortcuts ) {
        exerciseShortcutsService.saveExerciseShortcuts( aExerciseShortcuts );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aExerciseShortcuts );
    }

    /***
     * Edit ExerciseShortcuts - PUT API
     * @param aExerciseShortcuts - edited ExerciseShortcuts
     * @return Created or Bad Request
     */
    @PutMapping("/exerciseShortcuts/{aId}")
    public ResponseEntity<Void> edit( @RequestBody @Valid @NotNull ExerciseShortcuts aExerciseShortcuts, @PathVariable Long aId) {
        exerciseShortcutsService.getExerciseShortcutsById( aId ).map(exerciseShortcuts -> {
            exerciseShortcuts.setTranscription( aExerciseShortcuts.getTranscription() );
            exerciseShortcuts.setParsedTranscription( aExerciseShortcuts.parseTranscription() );
            exerciseShortcuts.setImage( aExerciseShortcuts.getImage() );
            return exerciseShortcutsService.saveExerciseShortcuts( exerciseShortcuts );
        }).orElseGet(() -> {
            aExerciseShortcuts.setId( aId );
            return exerciseShortcutsService.saveExerciseShortcuts( aExerciseShortcuts );
        });
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    /***
     * Delete ExerciseShortcuts - DELETE API
     * @param aId - Id of deleted ExerciseShortcuts
     * @return View of all ExercisesShortcuts after deleted one
     */
    @DeleteMapping(value = "/exerciseShortcuts/{aId}")
    public ResponseEntity<Void> delete( @PathVariable Long aId ) throws NotFoundException {
        exerciseShortcutsService.deleteExerciseShortcuts( aId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @TabFactory("Content")
    public void content( UiConfig aUiConfig, TabBuilder aTabBuilder ) {
        aTabBuilder.fields( aUiConfig.fields
                        .text( "transcription" )
                        .label( "transcription" )
                        .required(), aUiConfig.fields
                        .text( "image_path" )
                        .label( "image_path" )
                        .required()
                //uncomment this line if using blossom mvc
                //aUiConfig.fields.basicUpload( "image" ).label( "image" )
        );
    }

}

