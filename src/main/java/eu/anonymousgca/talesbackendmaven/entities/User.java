package eu.anonymousgca.talesbackendmaven.entities;

import eu.anonymousgca.talesbackendmaven.entities.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class User {
    @Id
    @Size(max = 255)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(max = 11)
    @Column(name = "gender", length = 11)
    private Gender gender;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @Column(name = "urlProfilePicture")
    private String urlProfilePicture;

    @Size(max = 255)
    @Column(name = "urlCoverPicture")
    private String urlCoverPicture;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Size(max = 255)
    @Column(name = "motto")
    private String motto;

    @Column(name = "showNSFW")
    private Boolean showNSFW;

    @Column(name = "ofAge")
    private Boolean ofAge;

    @Column(name = "isActivated")
    private Boolean isActivated;

    @Column(name = "isMuted")
    private Boolean isMuted;

    @Size(max = 50)
    @Column(name = "activationCode", length = 50)
    private String activationCode;

    @Column(name = "joinDate")
    private Instant joinDate;

    @Column(name = "canUpload")
    private Boolean canUpload;

}