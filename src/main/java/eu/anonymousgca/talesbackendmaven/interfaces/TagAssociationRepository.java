package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.TagAssociation;
import eu.anonymousgca.talesbackendmaven.entities.TagAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagAssociationRepository extends JpaRepository<TagAssociation, TagAssociationId> {
}