package pl.edu.amu.home.paleografia.hibernate.factory;

import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.ArrayList;
import java.util.List;

public class ExerciseShortcutsFactory {

    private static final String SHORTCUTS_PATH = "/backend-images/shortcuts/";

    private ExerciseShortcutsFactory() {
        // private Constructor to hide the public one
    }

    public static List<ExerciseShortcuts> createModelForTesting() {
        List<ExerciseShortcuts> exerciseShortcutsList = new ArrayList<>();

        var image1 = new Image.Builder()
                .path( SHORTCUTS_PATH + "EG.png" )
                .build();
        var exerciseShortcuts1 = new ExerciseShortcuts.Builder()
                .transcription( "exempli gratia" )
                .image( image1 )
                .build();

        var image2 = new Image.Builder()
                .path( SHORTCUTS_PATH + "ETC.png" )
                .build();
        var exerciseShortcuts2 = new ExerciseShortcuts.Builder()
                .transcription( "et cetera" )
                .image( image2 )
                .build();

        var image3 = new Image.Builder()
                .path( SHORTCUTS_PATH + "RIP.png" )
                .build();
        var exerciseShortcuts3 = new ExerciseShortcuts.Builder()
                .transcription( "requiescat in pace" )
                .image( image3 )
                .build();

        exerciseShortcutsList.add( exerciseShortcuts1 );
        exerciseShortcutsList.add( exerciseShortcuts2 );
        exerciseShortcutsList.add( exerciseShortcuts3 );

        return exerciseShortcutsList;
    }

    public static ExerciseShortcuts createDefaultForTests() {
        return new ExerciseShortcuts.Builder()
                .transcription( DefaultString.TRANSCRIPTION )
                .build();
    }
}
