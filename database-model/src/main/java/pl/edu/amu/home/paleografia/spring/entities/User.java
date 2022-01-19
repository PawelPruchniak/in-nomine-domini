package pl.edu.amu.home.paleografia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id_user",
        scope = ExerciseShortcuts.class)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    /*** Constructor ***/
    public User() {
        // Hibernate requires empty constructor
    }

    /*** Getter and Setters ***/
    public Long getId() {
        return id;
    }

    public void setId( Long aId ) {
        id = aId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String aUsername ) {
        username = aUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String aPassword ) {
        password = aPassword;
    }
}
