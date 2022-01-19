package pl.edu.amu.home.paleografia.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.amu.home.paleografia.spring.entities.User;
import pl.edu.amu.home.paleografia.spring.repositories.dao.UserDao;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername( String aUsername ) throws UsernameNotFoundException {
        User user = userDao.findByUsername( aUsername );
        if ( user == null ) {
            throw new UsernameNotFoundException( "User not found with username: " + aUsername );
        }
        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(),
                new ArrayList<>() );
    }

}
