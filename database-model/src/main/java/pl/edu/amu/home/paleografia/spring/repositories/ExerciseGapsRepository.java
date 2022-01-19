package pl.edu.amu.home.paleografia.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;

import java.util.List;

public interface ExerciseGapsRepository extends JpaRepository<ExerciseGaps, Long>, PagingAndSortingRepository<ExerciseGaps, Long> {

    List<ExerciseGaps> findByDifficultyLevel( Integer aDifficultyLevel );
}
