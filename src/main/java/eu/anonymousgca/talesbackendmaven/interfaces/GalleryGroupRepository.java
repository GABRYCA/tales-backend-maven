package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.GalleryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryGroupRepository extends JpaRepository<GalleryGroup, Long> {
}