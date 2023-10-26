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
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationId", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Size(max = 20)
    @Column(name = "notificationType", length = 20)
    private String notificationType;

    @NotNull
    @Column(name = "notificationDate", nullable = false)
    private Instant notificationDate;

    @NotNull
    @Column(name = "viewed", nullable = false)
    private Boolean viewed = false;

}