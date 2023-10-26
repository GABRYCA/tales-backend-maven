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
public class FriendId implements Serializable {
    @Serial
    private static final long serialVersionUID = -7071838272621844624L;
    @Size(max = 255)
    @NotNull
    @Column(name = "senderId", nullable = false)
    private String senderId;

    @Size(max = 255)
    @NotNull
    @Column(name = "receiverId", nullable = false)
    private String receiverId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FriendId entity = (FriendId) o;
        return Objects.equals(this.senderId, entity.senderId) &&
                Objects.equals(this.receiverId, entity.receiverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderId, receiverId);
    }

}