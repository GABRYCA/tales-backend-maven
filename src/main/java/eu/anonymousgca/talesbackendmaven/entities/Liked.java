package eu.anonymousgca.talesbackendmaven.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class Liked {
    @EmbeddedId
    private LikedId id;

    //TODO: JsonIgnore should be avoided

    @MapsId("contentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contentId", nullable = false)
    @JsonIgnore
    private Content content;
}