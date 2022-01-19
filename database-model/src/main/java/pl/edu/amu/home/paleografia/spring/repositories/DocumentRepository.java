package pl.edu.amu.home.paleografia.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.amu.home.paleografia.spring.entities.Document;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long>, PagingAndSortingRepository<Document, Long> {

    List<Document> findByDifficultyLevel( Integer aDifficultyLevel );

    List<Document> findByCentury( String aCentury );
}
