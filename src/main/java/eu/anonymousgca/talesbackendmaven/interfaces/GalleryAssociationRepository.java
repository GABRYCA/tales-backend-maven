package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.GalleryAssociation;
import eu.anonymousgca.talesbackendmaven.entities.GalleryAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryAssociationRepository extends JpaRepository<GalleryAssociation, GalleryAssociationId> {
}