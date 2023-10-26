package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Repost;
import eu.anonymousgca.talesbackendmaven.entities.RepostId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepostRepository extends JpaRepository<Repost, RepostId> {
}