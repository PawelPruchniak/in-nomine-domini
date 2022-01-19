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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseSentencesServiceIf;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Template(title = "Sentences manager", id = "paleografia/exercise_sentences")
@Controller
@RequestMapping("/security")
public class ExerciseSentencesTemplate {

    @Autowired
    private ExerciseSentencesServiceIf exerciseSentencesService;

    /***
     * Create ExerciseSentences - POST API
     * @param aExerciseSentences - created ExerciseSentences
     * @return Http Response
     */
    @PostMapping(value = "/exerciseSentences")
    public ResponseEntity<ExerciseSentences> create(
            @RequestBody @Valid @NotNull ExerciseSentences aExerciseSentences ) {
        exerciseSentencesService.saveExerciseSentences( aExerciseSentences );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aExerciseSentences );
    }

    /***
     * Edit ExerciseSentences - PUT API
     * @return Created or Bad Request
     */
    @PutMapping("/exerciseSentences/{aId}")
    public ResponseEntity<Void> edit( @RequestBody @Valid @NotNull ExerciseSentences aExerciseSentences, @PathVariable Long aId) {
        exerciseSentencesService.getExerciseSentencesById( aId ).map(exerciseSentences -> {
            exerciseSentences.setTranscription( aExerciseSentences.getTranscription() );
            exerciseSentences.setTranslation( aExerciseSentences.getTranscription() );
            exerciseSentences.setParsedTranscription( aExerciseSentences.parseTranscription() );
            exerciseSentences.setImage( aExerciseSentences.getImage() );
            return exerciseSentencesService.saveExerciseSentences( exerciseSentences );
        }).orElseGet(() -> {
            aExerciseSentences.setId( aId );
            return exerciseSentencesService.saveExerciseSentences( aExerciseSentences );
        });
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    /***
     * Delete ExerciseSentences - DELETE API
     * @param aId - Id of deleted ExerciseSentences
     * @return View of all ExercisesSentences after deleted one
     */
    @DeleteMapping(value = "/exerciseSentences/{aId}")
    public ResponseEntity<Void> delete( @PathVariable Long aId ) throws NotFoundException {
        exerciseSentencesService.deleteExerciseSentences( aId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @TabFactory("Content")
    public void content( UiConfig aUiConfig, TabBuilder aTabBuilder ) {
        aTabBuilder.fields( aUiConfig.fields
                        .text( "transcription" )
                        .label( "transcription" )
                        .required(), aUiConfig.fields
                        .text( "translation" )
                        .label( "translation" )
                        .required(), aUiConfig.fields
                        .text( "image_path" )
                        .label( "image_path" )
                        .required()
                //uncomment this line if using blossom mvc
                //aUiConfig.fields.basicUpload( "image" ).label( "image" )
        );
    }

}

