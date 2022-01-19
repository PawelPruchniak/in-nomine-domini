package pl.edu.amu.home.paleografia.spring.templates;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import javassist.NotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.services.interfaces.DocumentServiceIf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Template(title = "Document manager", id = "paleografia/documents")
@Controller
@RequestMapping("/security")
public class DocumentTemplate {

    @Autowired
    private DocumentServiceIf documentService;


    /***
     * Create Document - POST API
     * @param aDocument - created Document
     * @return Http Response
     */

    @PostMapping(value = "/document")
    public ResponseEntity<Document> create( @RequestBody @Valid @NotNull Document aDocument ) {
        documentService.saveDocument( aDocument );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aDocument );
    }

    /***
     * Edit Document - PUT API
     * @param aDocument - edited Document
     * @return Created or Bad Request
     */
    @PutMapping("/document/{aId}")
    public ResponseEntity<Void> edit( @RequestBody @Valid @NotNull Document aDocument, @PathVariable Long aId) {
                    documentService.getDocumentById( aId ).map(document -> {
                        document.setTranscription( aDocument.getTranscription() );
                        document.setDescription( aDocument.getDescription( ));
                        document.setCentury( aDocument.getCentury() );
                        document.setDifficultyLevel( aDocument.getDifficultyLevel() );
                        document.setParsedTranscription( aDocument.getParsedTranscription() );
                        document.setImage( aDocument.getImage() );
                        return documentService.saveDocument( document );
                    }).orElseGet(() -> {
                            aDocument.setId( aId );
                            return documentService.saveDocument( aDocument );
            });
        return new ResponseEntity<>( HttpStatus.CREATED );
    }



    /***
     * Delete Document - DELETE API
     * @param aId - Id of deleted Document
     * @return View of all Documents after deleted one
     */
    @DeleteMapping(value = "/document/{aId}")
    public ResponseEntity<Void> delete( @PathVariable Long aId ) throws NotFoundException {
        documentService.deleteDocument( aId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @TabFactory("Content")
    public void content( UiConfig aUiConfig, TabBuilder aTabBuilder ) {
        aTabBuilder.fields( aUiConfig.fields
                        .text( "transcription" )
                        .label( "transcription" )
                        .required(), aUiConfig.fields
                        .text( "description" )
                        .label( "description" )
                        .required(), aUiConfig.fields
                        .select( "century" )
                        .label( "century" )
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


    //Test functions:
    @RequestMapping("/docShow")
    public String render( ModelMap aModelMap ) {
        List<Document> documents = IterableUtils.toList( documentService.listAllDocuments() );
        aModelMap.put( "documents", documents );
        return "docList";
    }

    //Node problem - No primary or single public constructor found for interface javax.jcr.Node - and no default constructor found either] with root cause
    @RequestMapping("/docTest")
    public String renderTest( ModelMap aModelMap, HttpSession aHttpSession, HttpServletRequest aHttpServletRequest ) {

        if ( "add".equals( aHttpServletRequest.getParameter( "action" ) ) ) {
            Document document = new Document.Builder()
                    .transcription( StringUtils.defaultIfEmpty( aHttpServletRequest.getParameter( "transcription" ),
                            "Błąd wprowadzenia" ) )
                    .description( StringUtils.defaultIfEmpty( aHttpServletRequest.getParameter( "description" ),
                            "Błąd wprowadzenia" ) )
                    .century( StringUtils.defaultIfEmpty( aHttpServletRequest.getParameter( "century" ),
                            "Błąd wprowadzenia" ) )
                    .difficultyLevel( Integer.parseInt(
                            StringUtils.defaultIfEmpty( aHttpServletRequest.getParameter( "difficultyLevel" ), "1" ) ) )
                    .build();
            documentService.saveDocument( document );

            return render( aModelMap );
        }

        return "document";
    }

}

