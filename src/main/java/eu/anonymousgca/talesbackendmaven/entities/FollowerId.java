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
public class FollowerId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4034660613574893238L;
    @Size(max = 255)
    @NotNull
    @Column(name = "userId", nullable = false)
    private String userId;

    @Size(max = 255)
    @NotNull
    @Column(name = "followerId", nullable = false)
    private String followerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FollowerId entity = (FollowerId) o;
        return Objects.equals(this.followerId, entity.followerId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, userId);
    }

}