package pl.edu.amu.home.paleografia.hibernate.manager;

import pl.edu.amu.home.paleografia.hibernate.factory.DocumentFactory;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseGapsFactory;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseLettersFactory;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseSentencesFactory;
import pl.edu.amu.home.paleografia.hibernate.factory.ExerciseShortcutsFactory;
import pl.edu.amu.home.paleografia.spring.entities.Document;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseGaps;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseLetters;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseSentences;
import pl.edu.amu.home.paleografia.spring.entities.ExerciseShortcuts;

import java.util.ArrayList;
import java.util.List;

public class ModelManager {

    private static List<Document> documentList = new ArrayList<>();
    private static List<ExerciseGaps> exerciseGapsList = new ArrayList<>();
    private static List<ExerciseLetters> exerciseLettersList = new ArrayList<>();
    private static List<ExerciseShortcuts> exerciseShortcutsList = new ArrayList<>();
    private static List<ExerciseSentences> exerciseSentencesList = new ArrayList<>();

    public void init() {
        createModel();
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.addToDatabase();
    }

    private static void createModel() {
        documentList = DocumentFactory.createModelForTesting();
        exerciseGapsList = ExerciseGapsFactory.createModelForTesting();
        exerciseSentencesList = ExerciseSentencesFactory.createModelForTesting();
        exerciseLettersList = ExerciseLettersFactory.createModelForTesting();
        exerciseShortcutsList = ExerciseShortcutsFactory.createModelForTesting();
        serializeModel();
    }

    private static void serializeModel() {
        SerializerJson.serializeToFile( documentList );
        SerializerJson.serializeToFile( exerciseGapsList );
        SerializerJson.serializeToFile( exerciseSentencesList );
        SerializerJson.serializeToFile( exerciseLettersList );
        SerializerJson.serializeToFile( exerciseShortcutsList );
    }

}
