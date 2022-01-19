package pl.edu.amu.home.paleografia.hibernate.factory;


import pl.edu.amu.home.paleografia.hibernate.DefaultString;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.entities.Image;

import java.util.ArrayList;
import java.util.List;

public class ExerciseSentencesFactory {


    private static final String SENTENCES_PATH = "/backend-images/sentences/";

    private ExerciseSentencesFactory() {
        // private Constructor to hide the public one
    }

    public static List<ExerciseSentences> createModelForTesting() {
        List<ExerciseSentences> exerciseSentencesList = new ArrayList<>();

        var image1 = new Image.Builder()
                .path( SENTENCES_PATH + "zDeszczuPodRynne.png" )
                .build();
        var exerciseSentences1 = new ExerciseSentences.Builder()
                .transcription( "Ab equis ad asinos" )
                .translation( "Z deszczu pod rynnę" )
                .image( image1 )
                .build();

        var image2 = new Image.Builder()
                .path( SENTENCES_PATH + "MarnoscNadMarnosciami.png" )
                .build();
        var exerciseSentences2 = new ExerciseSentences.Builder()
                .transcription( "Vanitas vanitatum et omnia vanitas" )
                .translation( "Marność nad marnościami i wszystko marność" )
                .image( image2 )
                .build();

        var image3 = new Image.Builder()
                .path( SENTENCES_PATH + "MylicSieJestRzeczaLudzka.png" )
                .build();
        var exerciseSentences3 = new ExerciseSentences.Builder()
                .transcription( "Errare humanum est" )
                .translation( "Mylić się jest rzeczą ludzką" )
                .image( image3 )
                .build();

        var image4 = new Image.Builder()
                .path( SENTENCES_PATH + "MysleWiecJestem.png" )
                .build();
        var exerciseSentences4 = new ExerciseSentences.Builder()
                .transcription( "Cogito ergo sum" )
                .translation( "Myślę więc jestem" )
                .image( image4 )
                .build();

        var image5 = new Image.Builder()
                .path( SENTENCES_PATH + "SpieszSiePowoli.png" )
                .build();
        var exerciseSentences5 = new ExerciseSentences.Builder()
                .transcription( "Festina lente!" )
                .translation( "Śpiesz się powoli" )
                .image( image5 )
                .build();

        var image6 = new Image.Builder()
                .path( SENTENCES_PATH + "KsiegaZbaszynska.png" )
                .build();
        var exerciseSentences6 = new ExerciseSentences.Builder()
                .transcription(
                        "Anno Domini 1761 Die 13 mensis Juny Za Sławetnego Woyciecha Mybysa Burmistrza Przyiął mieyskie Prawo Maci Dąbrowski z Strzyżewa Rolnik" )
                .translation( "" )
                .image( image6 )
                .build();

        var image7 = new Image.Builder()
                .path( SENTENCES_PATH + "InNomineDominiAmen.png" )
                .build();
        var exerciseSentences7 = new ExerciseSentences.Builder()
                .transcription( "In nomine sancte et individue trinitatis amen." )
                .translation( "" )
                .image( image7 )
                .build();

        var image8 = new Image.Builder()
                .path( SENTENCES_PATH + "Zbylut.png" )
                .build();
        var exerciseSentences8 = new ExerciseSentences.Builder()
                .transcription( "Bolezlao Mesicone Henrico fratribus germanis in Polonia principantibus" )
                .translation( "" )
                .image( image8 )
                .build();

        var image9 = new Image.Builder()
                .path( SENTENCES_PATH + "Castor.png" )
                .build();
        var exerciseSentences9 = new ExerciseSentences.Builder()
                .transcription( "Castor dicitur a castrando" )
                .translation( "" )
                .image( image9 )
                .build();

        exerciseSentencesList.add( exerciseSentences1 );
        exerciseSentencesList.add( exerciseSentences2 );
        exerciseSentencesList.add( exerciseSentences3 );
        exerciseSentencesList.add( exerciseSentences4 );
        exerciseSentencesList.add( exerciseSentences5 );
        exerciseSentencesList.add( exerciseSentences6 );
        exerciseSentencesList.add( exerciseSentences7 );
        exerciseSentencesList.add( exerciseSentences8 );
        exerciseSentencesList.add( exerciseSentences9 );

        return exerciseSentencesList;
    }

    public static ExerciseSentences createDefaultForTests() {
        return new ExerciseSentences.Builder()
                .transcription( DefaultString.TRANSCRIPTION )
                .translation( DefaultString.TRANSLATION )
                .build();
    }
}
