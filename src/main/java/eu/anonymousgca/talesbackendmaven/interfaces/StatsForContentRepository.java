package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.StatsForContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsForContentRepository extends JpaRepository<StatsForContent, Integer> {
}