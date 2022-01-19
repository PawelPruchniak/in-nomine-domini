package pl.edu.amu.home.paleografia.spring.exception;

import javassist.NotFoundException;

import java.util.Optional;

public class RestPreconditions {

    // private constructor to hide public one
    private RestPreconditions() {
        throw new IllegalStateException( "Utility class" );
    }

    public static <T> T checkIfExists( Optional<T> aResource ) throws NotFoundException {
        if ( aResource.isEmpty() ) {
            throw new NotFoundException( "Resource not found" );
        }
        return aResource.get();
    }
}
