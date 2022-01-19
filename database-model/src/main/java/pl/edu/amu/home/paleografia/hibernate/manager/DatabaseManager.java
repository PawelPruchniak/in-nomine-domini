package pl.edu.amu.home.paleografia.hibernate.manager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.entities.User;

import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseManager {
    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger( DatabaseManager.class );

    public void addToDatabase() {
        jsonMapper.configure( JsonParser.Feature.AUTO_CLOSE_SOURCE, true );

        TypeReference<List<Document>> typeReferenceExerciseDocuments = new TypeReference<>() {};
        TypeReference<List<ExerciseGaps>> typeReferenceExerciseGaps = new TypeReference<>() {};
        TypeReference<List<ExerciseSentences>> typeReferenceExerciseSentences = new TypeReference<>() {};
        TypeReference<List<ExerciseLetters>> typeReferenceExerciseLetters = new TypeReference<>() {};
        TypeReference<List<ExerciseShortcuts>> typeReferenceExerciseShortcuts = new TypeReference<>() {};

        List<User> users = createMainUser();

        var jsonDocuments = new File( "Document.json" );
        var jsonExercisesGaps = new File( "ExerciseGaps.json" );
        var jsonExercisesSentences = new File( "ExerciseSentences.json" );
        var jsonExercisesLetters = new File( "ExerciseLetters.json" );
        var jsonExercisesShortcuts = new File( "ExerciseShortcuts.json" );

        String persistenceUnitName = "hibernate-dynamic";
        if ( isTestProfile() ) {
            addTestUser( users );
            persistenceUnitName = "hibernate-dynamic-test";
        }

        var entityManagerFactory = Persistence.createEntityManagerFactory( persistenceUnitName );
        var entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager
                    .getTransaction()
                    .begin();

            // Documents
            List<Document> documents = jsonMapper.readValue( jsonDocuments, typeReferenceExerciseDocuments );
            for ( Document document : documents ) {

                entityManager.persist( document );
            }
            logger.info( "All [Documents] data saved" );


            // Exercises Gaps
            List<ExerciseGaps> exercisesGaps = jsonMapper.readValue( jsonExercisesGaps, typeReferenceExerciseGaps );
            for ( ExerciseGaps exerciseGaps : exercisesGaps ) {

                entityManager.persist( exerciseGaps );
            }
            logger.info( "All [Exercises Gaps] data saved" );

            // Exercises Sentences
            List<ExerciseSentences> exercisesSentences = jsonMapper.readValue( jsonExercisesSentences,
                    typeReferenceExerciseSentences );
            for ( ExerciseSentences exerciseSentences : exercisesSentences ) {

                entityManager.persist( exerciseSentences );
            }
            logger.info( "All [Exercises Sentences] data saved" );

            // Exercises Letters
            List<ExerciseLetters> exercisesLetters = jsonMapper.readValue( jsonExercisesLetters,
                    typeReferenceExerciseLetters );
            for ( ExerciseLetters exerciseLetters : exercisesLetters ) {

                entityManager.persist( exerciseLetters );
            }
            logger.info( "All [Exercises Letters] data saved" );

            // Exercises Shortcuts
            List<ExerciseShortcuts> exercisesShortcuts = jsonMapper.readValue( jsonExercisesShortcuts,
                    typeReferenceExerciseShortcuts );
            for ( ExerciseShortcuts exerciseShortcuts : exercisesShortcuts ) {

                entityManager.persist( exerciseShortcuts );
            }
            logger.info( "All [Exercises Shortcuts] data saved" );

            for ( User user : users ) {
                entityManager.persist( user );
            }
            logger.info( "All [User] data saved" );

            entityManager
                    .getTransaction()
                    .commit();

        }
        catch ( IOException aIOException ) {
            logger.info( "Unable to save [Model]: " + aIOException.getMessage() );
        }
    }

    private List<User> createMainUser() {
        User mainUser = new User();
        mainUser.setUsername( "example_user" );
        mainUser.setPassword( "example_password_bcrypt" );

        List<User> userList = new ArrayList<>();
        userList.add( mainUser );

        return userList;
    }

    private void addTestUser( List<User> aUsers ) {
        User testUser = new User();
        testUser.setUsername( "example_test_user" );
        testUser.setPassword( "example_test_password_bcrypt" );
        aUsers.add( testUser );
    }

    private boolean isTestProfile() {
        boolean firstOption = false;
        boolean secondOption = false;
        var propertySun = Optional.ofNullable( System.getProperty( "sun.java.command" ) );
        var mvnCMD = Optional.ofNullable( System.getenv( "MAVEN_CMD_LINE_ARGS" ) );
        if ( propertySun.isPresent() ) {
            firstOption = propertySun
                    .get()
                    .equals( "pl.edu.amu.home.paleografia.spring.SpringApplication -Dspring-boot.run.profiles=test" );
        }
        if ( mvnCMD.isPresent() ) {
            secondOption = mvnCMD
                    .get()
                    .strip()
                    .equals( "spring-boot:run -Dspring-boot.run.profiles=test" );
        }

        return firstOption || secondOption;
    }
}
