package pl.edu.amu.home.paleografia.hibernate.factory;

import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLettersFactory {

    private static final String LETTERS_PATH = "/backend-images/letters/";

    private ExerciseLettersFactory() {
        // private Constructor to hide the public one
    }

    public static List<ExerciseLetters> createModelForTesting() {
        List<ExerciseLetters> exerciseLettersList = new ArrayList<>();

        var image1 = new Image.Builder()
                .path( LETTERS_PATH + "litera_A.png" )
                .build();
        var exerciseLetters1 = new ExerciseLetters.Builder()
                .transcription( "A" )
                .image( image1 )
                .build();

        var image2 = new Image.Builder()
                .path( LETTERS_PATH + "litera_c_mala.png" )
                .build();
        var exerciseLetters2 = new ExerciseLetters.Builder()
                .transcription( "c" )
                .image( image2 )
                .build();

        var image3 = new Image.Builder()
                .path( LETTERS_PATH + "litera_d_mala.png" )
                .build();
        var exerciseLetters3 = new ExerciseLetters.Builder()
                .transcription( "d" )
                .image( image3 )
                .build();

        var image4 = new Image.Builder()
                .path( LETTERS_PATH + "litera_e_mala.png" )
                .build();
        var exerciseLetters4 = new ExerciseLetters.Builder()
                .transcription( "e" )
                .image( image4 )
                .build();

        var image5 = new Image.Builder()
                .path( LETTERS_PATH + "litera_F.png" )
                .build();
        var exerciseLetters5 = new ExerciseLetters.Builder()
                .transcription( "F" )
                .image( image5 )
                .build();

        var image6 = new Image.Builder()
                .path( LETTERS_PATH + "litera_g_mala.png" )
                .build();
        var exerciseLetters6 = new ExerciseLetters.Builder()
                .transcription( "g" )
                .image( image6 )
                .build();

        var image7 = new Image.Builder()
                .path( LETTERS_PATH + "litera_K.png" )
                .build();
        var exerciseLetters7 = new ExerciseLetters.Builder()
                .transcription( "K" )
                .image( image7 )
                .build();

        var image8 = new Image.Builder()
                .path( LETTERS_PATH + "litera_L.png" )
                .build();
        var exerciseLetters8 = new ExerciseLetters.Builder()
                .transcription( "L" )
                .image( image8 )
                .build();

        var image9 = new Image.Builder()
                .path( LETTERS_PATH + "litera_l_mala.png" )
                .build();
        var exerciseLetters9 = new ExerciseLetters.Builder()
                .transcription( "l" )
                .image( image9 )
                .build();

        var image10 = new Image.Builder()
                .path( LETTERS_PATH + "litera_M.png" )
                .build();
        var exerciseLetters10 = new ExerciseLetters.Builder()
                .transcription( "M" )
                .image( image10 )
                .build();

        var image11 = new Image.Builder()
                .path( LETTERS_PATH + "litera_p_mala.png" )
                .build();
        var exerciseLetters11 = new ExerciseLetters.Builder()
                .transcription( "p" )
                .image( image11 )
                .build();

        var image12 = new Image.Builder()
                .path( LETTERS_PATH + "litera_T.png" )
                .build();
        var exerciseLetters12 = new ExerciseLetters.Builder()
                .transcription( "T" )
                .image( image12 )
                .build();

        var image13 = new Image.Builder()
                .path( LETTERS_PATH + "litera_y_mala.png" )
                .build();
        var exerciseLetters13 = new ExerciseLetters.Builder()
                .transcription( "y" )
                .image( image13 )
                .build();

        var image14 = new Image.Builder()
                .path( LETTERS_PATH + "litera_Z.png" )
                .build();
        var exerciseLetters14 = new ExerciseLetters.Builder()
                .transcription( "Z" )
                .image( image14 )
                .build();

        exerciseLettersList.add( exerciseLetters1 );
        exerciseLettersList.add( exerciseLetters2 );
        exerciseLettersList.add( exerciseLetters3 );
        exerciseLettersList.add( exerciseLetters4 );
        exerciseLettersList.add( exerciseLetters5 );
        exerciseLettersList.add( exerciseLetters6 );
        exerciseLettersList.add( exerciseLetters7 );
        exerciseLettersList.add( exerciseLetters8 );
        exerciseLettersList.add( exerciseLetters9 );
        exerciseLettersList.add( exerciseLetters10 );
        exerciseLettersList.add( exerciseLetters11 );
        exerciseLettersList.add( exerciseLetters12 );
        exerciseLettersList.add( exerciseLetters13 );
        exerciseLettersList.add( exerciseLetters14 );

        return exerciseLettersList;
    }

    public static ExerciseLetters createDefaultForTests() {
        return new ExerciseLetters.Builder()
                .transcription( DefaultString.TRANSCRIPTION )
                .build();
    }
}
