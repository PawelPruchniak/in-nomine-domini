package pl.edu.amu.home.paleografia.spring.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.exception.RestPreconditions;
import pl.edu.amu.home.paleografia.spring.services.interfaces.DocumentServiceIf;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class DocumentsController {

    @Autowired
    private DocumentServiceIf documentService;

    /***
     * Getting all Documents - GET API
     * @return List of all Documents
     */
    @GetMapping(value = "/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Document> list() {
        return documentService.listAllDocuments();
    }

    /***
     * Getting Document by Id - GET API
     * @param aId - Id of getted Document
     * @return one Document
     */
    @GetMapping(value = "/document/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Document getById( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( documentService.getDocumentById( aId ) );
    }

    /***
     * Getting Documents by Difficulty Level - GET API
     * @param aDifficultyLevel - difficulty Level of getted document
     * @return list of Documents
     */
    @GetMapping(value = "/document/diff/{difficultyLevel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Document> getByDifficultyLevel( @PathVariable("difficultyLevel") Integer aDifficultyLevel ) {
        return documentService.getDocumentByDifficultyLevel( aDifficultyLevel );
    }

    /***
     * Getting Documents By Century - GET API
     * @param aCentury - century of getted document
     * @return list of Documents
     */
    @GetMapping(value = "/document/century/{century}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Document> getByCentury( @PathVariable("century") String aCentury ) {
        return documentService.getDocumentByCentury( aCentury );
    }

    /***
     * Getting random Document excluding one with Id - GET API
     * @param aId - Id of excluded Document
     * @return one Document
     */
    @GetMapping(value = "/document/random/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Document getRandomDocument( @PathVariable("id") Long aId ) throws NotFoundException {
        return RestPreconditions.checkIfExists( documentService.getRandomDocument( aId ) );
    }

}
