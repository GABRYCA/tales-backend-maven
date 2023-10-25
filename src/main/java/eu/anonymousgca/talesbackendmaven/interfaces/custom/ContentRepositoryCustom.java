package eu.anonymousgca.talesbackendmaven.interfaces.custom;

import eu.anonymousgca.talesbackendmaven.entities.Content;

import java.util.List;

public interface ContentRepositoryCustom {
    List<Content> findByOwnerId(String ownerId);
}
