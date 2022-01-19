package pl.edu.amu.home.paleografia.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;

public interface ExerciseLettersRepository extends JpaRepository<ExerciseLetters, Long>, PagingAndSortingRepository<ExerciseLetters, Long> {

}
