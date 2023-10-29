package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.entities.Liked;
import eu.anonymousgca.talesbackendmaven.entities.LikedId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedRepository extends JpaRepository<Liked, LikedId> {

    // Find likes by content ID, which's contained in LikedId
    List<Liked> findByIdContentId(Long contentId);

    // Find by content ID and user ID
    Liked findByIdContentIdAndIdUserId(Long contentId, String userId);

    // Create a new like and save it by String username and Long contentId
    default Liked create(String username, Content content) {
        Liked like = new Liked();
        like.setId(new LikedId());
        like.getId().setUserId(username);
        like.getId().setContentId(content.getId());
        // Fetch content by id and add it to like
        like.setContent(content);
        return save(like);
    }
}