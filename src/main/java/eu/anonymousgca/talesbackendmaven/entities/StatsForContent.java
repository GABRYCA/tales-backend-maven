package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
public class StatsForContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contentId")
    private Content content;

    @NotNull
    @Column(name = "counter", nullable = false)
    private Integer counter;

    @Size(max = 39)
    @Column(name = "viewerIP", length = 39)
    private String viewerIP;

    @Column(name = "dateViewed")
    private Instant dateViewed;

}