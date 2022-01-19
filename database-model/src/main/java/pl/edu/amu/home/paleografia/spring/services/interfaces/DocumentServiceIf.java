package pl.edu.amu.home.paleografia.spring.services.interfaces;

import javassist.NotFoundException;
import pl.edu.amu.home.paleografia.spring.entities.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentServiceIf {

    Iterable<Document> listAllDocuments();

    Optional<Document> getDocumentById( Long aId );

    Document saveDocument( Document aDocument );

    void deleteDocument( Long aId ) throws NotFoundException;

    List<Document> getDocumentByDifficultyLevel( Integer aDifficultyLevel );

    List<Document> getDocumentByCentury( String aCentury );

    Optional<Document> getRandomDocument( Long aId );
}
