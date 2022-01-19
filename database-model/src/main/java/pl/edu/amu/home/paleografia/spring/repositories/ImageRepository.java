package pl.edu.amu.home.paleografia.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.amu.home.paleografia.spring.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long>, PagingAndSortingRepository<Image, Long> {

}
