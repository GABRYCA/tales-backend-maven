package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name="gender", length = 11, nullable = false, columnDefinition = "unspecified")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="urlProfilePicture", columnDefinition = "common/assets/profile.webp")
    private String urlProfilePicture;

    @Column(name="urlCoverPicture", columnDefinition = "common/assets/cover.webp")
    private String urlCoverPicture;

    @Column(name="description")
    private String description;

    @Column(name="motto", columnDefinition = "I'm a new user!")
    private String motto;

    @Column(name="showNSFW", nullable = false, columnDefinition = "0")
    private boolean showNSFW;

    @Column(name="ofAge", nullable = false, columnDefinition = "1")
    private boolean ofAge;

    @Column(name="isActivated", nullable = false, columnDefinition = "0")
    private boolean isActivated;

    @Column(name="isMuted", nullable = false, columnDefinition = "0")
    private boolean isMuted;

    @Column(name="canUpload", nullable = false, columnDefinition = "0")
    private boolean canUpload;

    @Column(name="activationCode", length = 50)
    private String activationCode;

    @Column(name="joinDate", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joinDate;

    // @JsonManagedReference
    //@JsonIgnore
    /*@OneToMany(mappedBy = "ownerIdObject")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Content> contentList;*/
}
