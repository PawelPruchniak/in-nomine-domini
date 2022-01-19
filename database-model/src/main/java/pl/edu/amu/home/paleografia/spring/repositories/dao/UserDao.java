package pl.edu.amu.home.paleografia.spring.repositories.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.amu.home.paleografia.spring.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername( String username );

}