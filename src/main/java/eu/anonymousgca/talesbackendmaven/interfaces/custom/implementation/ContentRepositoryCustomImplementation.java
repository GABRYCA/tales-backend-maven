package eu.anonymousgca.talesbackendmaven.interfaces.custom.implementation;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.interfaces.ContentRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.custom.ContentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentRepositoryCustomImplementation implements ContentRepositoryCustom {

    @Autowired
    ContentRepository contentRepository;

    @Override
    public List<Content> findByOwnerId(String ownerId) {
        // Get all content, filtered by username
        List<Content> allContent = contentRepository.findAll();
        allContent.removeIf(content -> !content.getOwnerId().equals(ownerId));

        return allContent;
    }

}
