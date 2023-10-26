package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class GalleryAssociation {
    @EmbeddedId
    private GalleryAssociationId id;

    @MapsId("contentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contentId", nullable = false)
    private Content content;

}