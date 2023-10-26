package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.Premium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumRepository extends JpaRepository<Premium, Integer> {
}