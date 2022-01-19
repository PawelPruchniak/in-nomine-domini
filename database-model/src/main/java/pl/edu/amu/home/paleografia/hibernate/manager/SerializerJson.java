package pl.edu.amu.home.paleografia.hibernate.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializerJson {

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger( SerializerJson.class );

    private SerializerJson() {
        throw new IllegalStateException( "Utility class" );
    }

    public static <T> void serializeToFile( List<T> aDataList ) {
        var className = getClassName( aDataList );
        try {
            jsonMapper.writeValue( new File( className + ".json" ), aDataList );
            logger.info( "[" + className + "] serialized properly" );
        }
        catch ( IOException aIOException ) {
            logger.info( "Error while serializing [" + className + "]: " + aIOException.getMessage() );
        }
    }

    private static <T> String getClassName( List<T> aList ) {
        var className = aList
                .get( 0 )
                .getClass()
                .getName();
        return className.substring( className.lastIndexOf( "." ) + 1 );
    }
}
