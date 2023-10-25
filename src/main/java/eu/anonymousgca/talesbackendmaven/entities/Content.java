package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentId", nullable = false, unique = true)
    private Long contentId;

    // @JsonBackReference
    /* @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "username", nullable = false)
    private User ownerIdObject;*/

    @Column(name="ownerId", nullable = false)
    private String ownerId;

    @Column(name="type", length=10)
    private String type;

    @Column(name="urlImage")
    private String urlImage;

    @Column(name="textContent")
    private String textContent;

    @Column(name="title")
    private String title;

    @Column(name="description", columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(name="uploadDate", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime uploadDate;

    @Column(name="isPrivate", nullable = false, columnDefinition = "0")
    private boolean isPrivate;

    @Column(name="isAI", nullable = false, columnDefinition = "0")
    private boolean isAI;
}
