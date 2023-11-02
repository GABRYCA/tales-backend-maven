package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.GalleryAssociation;
import eu.anonymousgca.talesbackendmaven.entities.GalleryAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryAssociationRepository extends JpaRepository<GalleryAssociation, GalleryAssociationId> {
    List<GalleryAssociation> findByIdContentId(Long contentId);

    // Find by galleryId
    List<GalleryAssociation> findByIdGalleryId(Long galleryId);
}