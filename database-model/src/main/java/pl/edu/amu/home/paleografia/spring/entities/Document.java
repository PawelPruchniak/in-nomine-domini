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
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id_doc",
        scope = Document.class )
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "transcription", length = 10000)
    private String transcription;

    @Column(name = "description")
    private String description;

    @Column(name = "century")
    private String century;

    @Column(name = "difficultyLevel")
    private Integer difficultyLevel;

    @Transient
    List<ArrayList<String>> parsedTranscription = new ArrayList<>();


    /*** Relations ***/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    /*** Constructor ***/
    public Document() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription( String aDescription ) {
        description = aDescription;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury( String aCentury ) {
        century = aCentury;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel( Integer aDifficultyLevel ) {
        difficultyLevel = aDifficultyLevel;
    }

    public Image getImage() {
        return image;
    }

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
        var document = (Document) aO;
        return id.equals( document.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "Documents{" + "id=" + getId() + ", transcription='" + getTranscription() + "'" + ", description='" + getDescription() + "'" + ", century='" + getCentury() + "'" + ", difficultyLevel=" + getDifficultyLevel() + "}";
    }

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private String transcription;
        private String description;
        private String century;
        private Integer difficultyLevel;
        private Image image;

        public Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public Builder transcription( String aTranscription ) {
            this.transcription = aTranscription;
            return this;
        }

        public Builder description( String aDescription ) {
            this.description = aDescription;
            return this;
        }

        public Builder century( String aCentury ) {
            this.century = aCentury;
            return this;
        }

        public Builder difficultyLevel( Integer aDifficultyLevel ) {
            this.difficultyLevel = aDifficultyLevel;
            return this;
        }

        public Builder image( Image aImage ) {
            this.image = aImage;
            return this;
        }

        public Document build() {

            var newDocument = createInstance();
            if ( id != null ) {
                newDocument.id = id;
            }
            if ( transcription != null ) {
                newDocument.transcription = transcription;
            }
            if ( description != null ) {
                newDocument.description = description;
            }
            if ( century != null ) {
                newDocument.century = century;
            }
            if ( difficultyLevel != null ) {
                newDocument.difficultyLevel = difficultyLevel;
            }
            if ( image != null ) {
                newDocument.image = image;
            }
            return newDocument;
        }

        Document createInstance() {
            return new Document();
        }
    }
}
