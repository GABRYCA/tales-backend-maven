package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Liked;
import eu.anonymousgca.talesbackendmaven.entities.LikedId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedRepository extends JpaRepository<Liked, LikedId> {

    // Find likes by content ID, which's contained in LikedId
    List<Liked> findByIdContentId(Long contentId);

}