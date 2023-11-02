package eu.anonymousgca.talesbackendmaven.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentId", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "ownerId")
    private String ownerId;

    @Size(max = 10)
    @Column(name = "type", length = 10)
    private String type;

    @Size(max = 255)
    @Column(name = "urlImage")
    private String urlImage;

    @Size(max = 255)
    @Column(name = "textContent")
    private String textContent;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "uploadDate", nullable = false)
    private Instant uploadDate;

    @NotNull
    @Column(name = "isPrivate", nullable = false)
    private Boolean isPrivate = false;

    @Column(name = "isAI")
    private Boolean isAI;
}