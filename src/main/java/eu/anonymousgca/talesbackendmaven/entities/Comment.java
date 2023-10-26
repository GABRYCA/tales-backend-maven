package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "userId")
    private String userId;

    @NotNull
    @Column(name = "contentId")
    private Long contentId;

    @Size(max = 255)
    @NotNull
    @Column(name = "commentText", nullable = false)
    private String commentText;

    @NotNull
    @Column(name = "commentDate", nullable = false)
    private Instant commentDate;

}