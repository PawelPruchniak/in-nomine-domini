package pl.edu.amu.home.paleografia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id_img", scope = Image.class)
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "lightPath")
    private String lightPath;

    /*** Constructor ***/
    public Image() {
        // Hibernate requires empty constructor
    }

    /*** Setters and Getters ***/
    public Long getId() {
        return id;
    }

    public void setId( Long aId ) {
        id = aId;
    }

    public String getPath() {
        return path;
    }

    public void setPath( String aPath ) {
        path = aPath;
    }

    public String getLightPath() {
        if ( lightPath == null || lightPath.isEmpty() ) {
            return path;
        }
        else {
            return lightPath;
        }
    }

    public void setLightPath( String aLightPath ) {
        lightPath = aLightPath;
    }

    @Override
    public boolean equals( Object aO ) {
        if ( this == aO )
            return true;
        if ( aO == null || getClass() != aO.getClass() )
            return false;
        var that = (Image) aO;
        return id.equals( that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", path='" + path + '\'' + ", lightPath='" + lightPath + '\'' + '}';
    }

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private String path;
        private String lightPath;

        public Image.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public Image.Builder path( String aPath ) {
            this.path = aPath;
            return this;
        }

        public Image.Builder lightPath( String aLightPath ) {
            this.lightPath = aLightPath;
            return this;
        }

        public Image build() {

            var newImage = createInstance();
            if ( id != null ) {
                newImage.id = id;
            }
            if ( path != null ) {
                newImage.path = path;
            }
            if ( lightPath != null ) {
                newImage.lightPath = lightPath;
            }

            return newImage;
        }

        Image createInstance() {
            return new Image();
        }
    }
}
