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
public class TagAssociationId implements Serializable {
    @Serial
    private static final long serialVersionUID = 1630293129557019799L;
    @NotNull
    @Column(name = "tagId", nullable = false)
    private Integer tagId;

    @NotNull
    @Column(name = "contentId", nullable = false)
    private Integer contentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TagAssociationId entity = (TagAssociationId) o;
        return Objects.equals(this.tagId, entity.tagId) &&
                Objects.equals(this.contentId, entity.contentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, contentId);
    }

}