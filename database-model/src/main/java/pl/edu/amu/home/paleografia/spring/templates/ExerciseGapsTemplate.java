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
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.services.interfaces.ExerciseGapsServiceIf;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Template(title = "Gaps manager", id = "paleografia/exercise_gaps")
@Controller
@RequestMapping("/security")
public class ExerciseGapsTemplate {

    @Autowired
    private ExerciseGapsServiceIf exerciseGapsService;


    /***
     * Create ExerciseGaps - POST API
     * @param aExerciseGaps - created ExerciseGaps
     * @return Http Response
     */
    @PostMapping(value = "/exerciseGaps")
    public ResponseEntity<ExerciseGaps> create( @RequestBody @Valid @NotNull ExerciseGaps aExerciseGaps ) {
        exerciseGapsService.saveExerciseGaps( aExerciseGaps );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aExerciseGaps );
    }

    /***
     * Edit ExerciseGaps - PUT API
     * @param aExerciseGaps - edited ExerciseGaps
     * @return Created or Bad Request
     */
    @PutMapping("/exerciseGaps/{aId}")
    public ResponseEntity<Void> edit( @RequestBody @Valid @NotNull ExerciseGaps aExerciseGaps, @PathVariable Long aId) {
        exerciseGapsService.getExerciseGapsById( aId ).map(exerciseGaps -> {
            exerciseGaps.setTranscription( aExerciseGaps.getTranscription() );
            exerciseGaps.setDifficultyLevel( aExerciseGaps.getDifficultyLevel() );
            exerciseGaps.setParsedTranscription( aExerciseGaps.parseTranscription() );
            exerciseGaps.setImage( aExerciseGaps.getImage() );
            return exerciseGapsService.saveExerciseGaps( exerciseGaps );
        }).orElseGet(() -> {
            aExerciseGaps.setId( aId );
            return exerciseGapsService.saveExerciseGaps( aExerciseGaps );
        });
        return new ResponseEntity<>( HttpStatus.CREATED );
    }


    /***
     * Delete ExerciseGaps - DELETE API
     * @param aId - Id of deleted ExerciseGaps
     * @return View of all ExercisesGaps after deleted one
     */
    @DeleteMapping(value = "/exerciseGaps/{aId}")
    public ResponseEntity<Void> delete( @PathVariable Long aId ) throws NotFoundException {
        exerciseGapsService.deleteExerciseGaps( aId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @TabFactory("Content")
    public void content( UiConfig aUiConfig, TabBuilder aTabBuilder ) {
        aTabBuilder.fields( aUiConfig.fields
                        .text( "transcription" )
                        .label( "transcription" )
                        .required(), aUiConfig.fields
                        .select( "difficultyLevel" )
                        .label( "difficultyLevel" )
                        .required(), aUiConfig.fields
                        .text( "image_path" )
                        .label( "image_path" )
                        .required()
                //uncomment this line if using blossom mvc
                //aUiConfig.fields.basicUpload( "image" ).label( "image" )
        );
    }

}

