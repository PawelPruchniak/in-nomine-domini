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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseLettersServiceIf;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Template(title = "Letters manager", id = "paleografia/exercise_letters")
@Controller
@RequestMapping("/security")
public class ExerciseLettersTemplate {

    @Autowired
    private ExerciseLettersServiceIf exerciseLettersService;


    /***
     * Create ExerciseLetters - POST API
     * @param aExerciseSentences - created ExerciseLetters
     * @return Http Response
     */
    @PostMapping(value = "/exerciseLetters")
    public ResponseEntity<ExerciseLetters> create( @RequestBody @Valid @NotNull ExerciseLetters aExerciseSentences ) {
        exerciseLettersService.saveExerciseLetters( aExerciseSentences );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aExerciseSentences );
    }

    /***
     * Edit ExerciseLetters - PUT API
     * @param aExerciseLetters - edited ExerciseLetters
     * @return Created or Bad Request
     */
    @PutMapping("/exerciseLetters/{aId}")
    public ResponseEntity<Void> edit( @RequestBody @Valid @NotNull ExerciseLetters aExerciseLetters, @PathVariable Long aId) {
        exerciseLettersService.getExerciseLettersById( aId ).map(exerciseLetters -> {
            exerciseLetters.setTranscription( aExerciseLetters.getTranscription() );
            exerciseLetters.setImage( aExerciseLetters.getImage() );
            return exerciseLettersService.saveExerciseLetters( exerciseLetters );
        }).orElseGet(() -> {
            aExerciseLetters.setId( aId );
            return exerciseLettersService.saveExerciseLetters( aExerciseLetters );
        });
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    /***
     * Delete ExerciseLetters - DELETE API
     * @param aId - Id of deleted ExerciseLetters
     * @return View of all ExercisesLetters after deleted one
     */
    @DeleteMapping(value = "/exerciseLetters/{aId}")
    public ResponseEntity<Void> delete( @PathVariable Long aId ) throws NotFoundException {
        exerciseLettersService.deleteExerciseLetters( aId );
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

