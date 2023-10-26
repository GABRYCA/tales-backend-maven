package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RepostId implements Serializable {
    @Serial
    private static final long serialVersionUID = 3776515590285253475L;
    @Size(max = 255)
    @NotNull
    @Column(name = "userId", nullable = false)
    private String userId;

    @NotNull
    @Column(name = "contentId", nullable = false)
    private Integer contentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RepostId entity = (RepostId) o;
        return Objects.equals(this.contentId, entity.contentId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentId, userId);
    }

}