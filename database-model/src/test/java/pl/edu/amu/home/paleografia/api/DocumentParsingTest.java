package pl.edu.amu.home.paleografia.api;

import org.junit.jupiter.api.Test;
import pl.edu.amu.home.paleografia.spring.entities.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DocumentParsingTest {

    @Test
    void parsedTranscritpionShouldBeCreateOnGet() {
        var document1 = new Document.Builder()
                .transcription( "Post emensos insuperabilis expeditionis eventus languentibus partium animis" )
                .build();
        List<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> expectedLine1 = new ArrayList<>();
        Collections.addAll( expectedLine1, "Post", "emensos", "insuperabilis", "expeditionis", "eventus",
                "languentibus", "partium", "animis" );
        expected.add( expectedLine1 );
        assertEquals( expected, document1.getParsedTranscription() );
    }

    @Test
    void parsedTranscriptionShouldCreateNewLines() {
        var document1 = new Document.Builder()
                .transcription( "Post emensos insuperabilis expeditionis \neventus languentibus partium animis" )
                .build();
        List<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> expectedLine1 = new ArrayList<>();
        ArrayList<String> expectedLine2 = new ArrayList<>();
        Collections.addAll( expectedLine1, "Post", "emensos", "insuperabilis", "expeditionis" );
        Collections.addAll( expectedLine2, "eventus", "languentibus", "partium", "animis" );
        expected.add( expectedLine1 );
        expected.add( expectedLine2 );
        assertEquals( expected, document1.getParsedTranscription() );
    }

    @Test
    void parsedTranscriptionShouldIgnoreMultipleSpaces() {
        var document1 = new Document.Builder()
                .transcription(
                        "Post emensos           insuperabilis expeditionis          eventus languentibus partium animis" )
                .build();
        List<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> expectedLine1 = new ArrayList<>();
        Collections.addAll( expectedLine1, "Post", "emensos", "insuperabilis", "expeditionis", "eventus",
                "languentibus", "partium", "animis" );
        expected.add( expectedLine1 );
        assertEquals( expected, document1.getParsedTranscription() );
    }

    @Test
    void parsedTranscriptionShouldNotTakefirstSpaceInLineAsWord() {
        var document1 = new Document.Builder()
                .transcription( "Post emensos insuperabilis expeditionis \n eventus languentibus partium animis" )
                .build();
        List<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> expectedLine1 = new ArrayList<>();
        ArrayList<String> expectedLine2 = new ArrayList<>();
        Collections.addAll( expectedLine1, "Post", "emensos", "insuperabilis", "expeditionis" );
        Collections.addAll( expectedLine2, "eventus", "languentibus", "partium", "animis" );
        expected.add( expectedLine1 );
        expected.add( expectedLine2 );
        assertEquals( expected, document1.getParsedTranscription() );
    }

    @Test
    void parsedTranscriptionShouldNotAddEmtyLines() {
        var document1 = new Document.Builder()
                .transcription(
                        "Post emensos insuperabilis expeditionis \n eventus languentibus partium animis \n \n \n \n " )
                .build();
        assertEquals( 2, document1
                .getParsedTranscription()
                .size() );
    }


}
