package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Friend {
    @EmbeddedId
    private FriendId id;

    @NotNull
    @Column(name = "accepted", nullable = false)
    private Boolean accepted = false;

}