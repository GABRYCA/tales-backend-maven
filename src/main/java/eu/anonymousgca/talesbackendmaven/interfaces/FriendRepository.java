package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Friend;
import eu.anonymousgca.talesbackendmaven.entities.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, FriendId> {
}