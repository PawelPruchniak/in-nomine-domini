package pl.edu.amu.home.paleografia.spring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.repositories.DocumentRepository;
import pl.edu.amu.home.paleografia.spring.services.interfaces.DocumentServiceIf;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DocumentService implements DocumentServiceIf {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Iterable<Document> listAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> getDocumentById( Long aId ) {
        return documentRepository.findById( aId );
    }

    @Override
    public Document saveDocument( Document aDocument ) {
        return documentRepository.save( aDocument );
    }

    @Override
    public void deleteDocument( Long aId ) throws NotFoundException {
        var document = documentRepository.findById( aId );
        if ( document.isPresent() ) {
            documentRepository.delete( document.get() );
        }
        else {
            throw new NotFoundException( "Document with id=" + aId + " do not exists" );
        }
    }

    @Override
    public List<Document> getDocumentByDifficultyLevel( Integer aDifficultyLevel ) {
        return documentRepository.findByDifficultyLevel( aDifficultyLevel );
    }

    @Override
    public List<Document> getDocumentByCentury( String aCentury ) {
        return documentRepository.findByCentury( aCentury );
    }

    @Override
    public Optional<Document> getRandomDocument( Long aId ) {
        List<Document> allDocuments = documentRepository.findAll();
        deleteDocumentFromList( allDocuments, aId );

        return pickRandomDocument( allDocuments );
    }

    private Optional<Document> pickRandomDocument( List<Document> aAllDocuments ) {
        Random rand = new Random();
        return Optional.ofNullable( aAllDocuments.get( rand.nextInt( aAllDocuments.size() ) ) );
    }

    private void deleteDocumentFromList( List<Document> aAllDocuments, Long aId ) {
        aAllDocuments.removeIf( document -> document
                .getId()
                .equals( aId ) );
    }
}
