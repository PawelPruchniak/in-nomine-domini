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
import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id_ex_letters",
        scope = ExerciseLetters.class)
@Entity
@Table(name = "letters")
public class ExerciseLetters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "transcription", nullable = false)
    private String transcription;

    /*** Relations ***/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    /*** Constructor ***/
    public ExerciseLetters() {
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

    public Image getImage() {
        return image;
    }

    public void setImage( Image aImage ) {
        image = aImage;
    }

    /*** Override Java Object methods ***/
    @Override
    public boolean equals( Object aO ) {
        if ( this == aO )
            return true;
        if ( aO == null || getClass() != aO.getClass() )
            return false;
        var that = (ExerciseLetters) aO;
        return id.equals( that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "ExerciseLetters{" + "id=" + getId() + ", transcription='" + getTranscription() + "'" + "}";
    }

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private String transcription;
        private Image image;

        public ExerciseLetters.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public ExerciseLetters.Builder transcription( String aTranscription ) {
            this.transcription = aTranscription;
            return this;
        }

        public ExerciseLetters.Builder image( Image aImage ) {
            this.image = aImage;
            return this;
        }

        public ExerciseLetters build() {

            var newExerciseLetters = createInstance();
            if ( id != null ) {
                newExerciseLetters.id = id;
            }
            if ( transcription != null ) {
                newExerciseLetters.transcription = transcription;
            }
            if ( image != null ) {
                newExerciseLetters.image = image;
            }
            return newExerciseLetters;
        }

        ExerciseLetters createInstance() {
            return new ExerciseLetters();
        }
    }
}
