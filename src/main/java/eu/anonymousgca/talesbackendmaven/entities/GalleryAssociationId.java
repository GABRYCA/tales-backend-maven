package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GalleryAssociationId implements Serializable {
    @Serial
    private static final long serialVersionUID = -322409898706326663L;
    @NotNull
    @Column(name = "galleryId", nullable = false)
    private Long galleryId;

    @NotNull
    @Column(name = "contentId", nullable = false)
    private Long contentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GalleryAssociationId entity = (GalleryAssociationId) o;
        return Objects.equals(this.galleryId, entity.galleryId) &&
                Objects.equals(this.contentId, entity.contentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(galleryId, contentId);
    }

}