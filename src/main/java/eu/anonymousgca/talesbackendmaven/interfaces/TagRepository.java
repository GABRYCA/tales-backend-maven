package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}