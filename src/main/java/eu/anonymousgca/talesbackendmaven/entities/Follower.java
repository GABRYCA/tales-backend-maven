package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Follower {
    @EmbeddedId
    private FollowerId id;

    //TODO [JPA Buddy] generate columns from DB
}