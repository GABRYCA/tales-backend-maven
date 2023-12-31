package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByOwnerId(String ownerId);

    List<Content> findAllById(Long contentId);

    List<Content> findByIdIn(List<Long> contentIdList);
}

