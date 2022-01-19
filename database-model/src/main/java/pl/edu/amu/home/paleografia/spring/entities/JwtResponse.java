package pl.edu.amu.home.paleografia.spring.entities;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = - 8091879091924046844L;
    private final String jwtToken;

    public JwtResponse( String aJwtToken ) {
        this.jwtToken = aJwtToken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
