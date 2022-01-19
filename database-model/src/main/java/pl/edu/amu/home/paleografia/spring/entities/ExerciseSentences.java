package pl.edu.amu.home.paleografia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id_ex_sentences",
        scope = ExerciseSentences.class)
@Entity
@Table(name = "sentences")
public class ExerciseSentences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "transcription", nullable = false, length = 10000)
    private String transcription;

    @Column(name = "translation", length = 10000)
    private String translation;

    @Transient
    List<ArrayList<String>> parsedTranscription = new ArrayList<>();

    /*** Relations ***/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    /*** Constructor ***/
    public ExerciseSentences() {
        // Hibernate requires empty constructor
    }


    /*** Setters and Getters ***/
    public Long getId() {
        return id;
    }

    public void setId( Long aId ) {
        id = aId;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription( String aTranscription ) {
        transcription = aTranscription;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation( String aTranslation ) {
        translation = aTranslation;
    }

    public Image getImage() {return image;}

    public void setImage( Image aImage ) {
        image = aImage;
    }

    public List<ArrayList<String>> getParsedTranscription() {
        if ( this.parsedTranscription.isEmpty() ) {
            this.parsedTranscription = parseTranscription();
        }
        return parseTranscription();
    }

    public void setParsedTranscription( List<ArrayList<String>> aParsedTranscription ) {
        this.parsedTranscription = aParsedTranscription;
    }

    public List<ArrayList<String>> parseTranscription() {
        assert transcription != null;
        List<ArrayList<String>> parse = new ArrayList<>();
        String[] lines = transcription.split( "\\r?\\n" );
        var i = 0;
        for ( String line : lines ) {
            List<String> a1;
            parse.add( new ArrayList<>() );
            a1 = Arrays.asList( line.split( "\\s+" ) );
            for ( String word : a1 ) {
                word = word.replace( ",", "" );
                parse
                        .get( i )
                        .add( word );
            }
            parse
                    .get( i )
                    .remove( "" );
            if ( parse
                    .get( i )
                    .isEmpty() ) {
                parse.remove( i );
            }
            else {
                i++;
            }
        }
        return parse;
    }

    /*** Override Java Object methods ***/
    @Override
    public boolean equals( Object aO ) {
        if ( this == aO )
            return true;
        if ( aO == null || getClass() != aO.getClass() )
            return false;
        var that = (ExerciseSentences) aO;
        return id.equals( that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "ExerciseSentences{" + "id=" + getId() + ", transcription='" + getTranscription() + "'" + ", translation='" + getTranslation() + "'" + "}";
    }

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private String transcription;
        private String translation;
        private Image image;

        public ExerciseSentences.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public ExerciseSentences.Builder transcription( String aTranscription ) {
            this.transcription = aTranscription;
            return this;
        }

        public ExerciseSentences.Builder translation( String aTranslation ) {
            this.translation = aTranslation;
            return this;
        }

        public ExerciseSentences.Builder image( Image aImage ) {
            this.image = aImage;
            return this;
        }

        public ExerciseSentences build() {

            var newExerciseShortcuts = createInstance();
            if ( id != null ) {
                newExerciseShortcuts.id = id;
            }
            if ( transcription != null ) {
                newExerciseShortcuts.transcription = transcription;
            }
            if ( translation != null ) {
                newExerciseShortcuts.translation = translation;
            }
            if ( image != null ) {
                newExerciseShortcuts.image = image;
            }
            return newExerciseShortcuts;
        }

        ExerciseSentences createInstance() {
            return new ExerciseSentences();
        }
    }
}
