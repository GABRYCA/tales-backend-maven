package eu.anonymousgca.talesbackendmaven.interfaces;

import eu.anonymousgca.talesbackendmaven.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    // Get user by username and activationCode (used for activation)
    User findByUsernameAndActivationCode(String username, String activationCode);

}
