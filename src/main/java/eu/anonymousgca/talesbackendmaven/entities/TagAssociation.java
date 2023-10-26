package eu.anonymousgca.talesbackendmaven.entities;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.entities.Tag;
import eu.anonymousgca.talesbackendmaven.entities.TagAssociationId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class TagAssociation {
    @EmbeddedId
    private TagAssociationId id;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tagId", nullable = false)
    private Tag tag;

    @MapsId("contentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contentId", nullable = false)
    private Content content;

}