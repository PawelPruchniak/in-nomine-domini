package pl.edu.amu.home.paleografia.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.amu.home.paleografia.spring.entities.JwtRequest;
import pl.edu.amu.home.paleografia.spring.entities.JwtResponse;
import pl.edu.amu.home.paleografia.spring.security.JwtTokenUtil;

import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken( @RequestBody JwtRequest aAuthenticationRequest ) {

        authenticate( aAuthenticationRequest.getUsername(), aAuthenticationRequest.getPassword() );

        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(
                aAuthenticationRequest.getUsername() );

        final String token = jwtTokenUtil.generateToken( userDetails );

        return ResponseEntity.ok( new JwtResponse( token ) );
    }

    private void authenticate( String aUsername, String aPassword ) throws DisabledException, BadCredentialsException {
        Objects.requireNonNull( aUsername );
        Objects.requireNonNull( aPassword );

        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( aUsername, aPassword ) );
        }
        catch ( DisabledException e ) {
            throw new DisabledException( "USER_DISABLED", e );
        }
        catch ( BadCredentialsException e ) {
            throw new BadCredentialsException( "INVALID_CREDENTIALS", e );
        }
    }
}
