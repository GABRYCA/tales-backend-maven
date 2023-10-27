package eu.anonymousgca.talesbackendmaven.controllers;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.entities.User;
import eu.anonymousgca.talesbackendmaven.exceptions.UserNotFoundException;
import eu.anonymousgca.talesbackendmaven.interfaces.ContentRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        return userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @GetMapping("/{username}/activation/{activationCode}")
    public User getUserByActivationCode(@PathVariable String username, @PathVariable String activationCode) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // search for user by username and activation code, if found, activate account setting activationCode to null and isActivated to true
        User user = userRepository.findByUsernameAndActivationCode(username, activationCode);

        if (user == null) {
            throw new IllegalArgumentException("User and activation code not found!");
        }

        user.setActivationCode(null);
        user.setIsActivated(true);

        userRepository.save(user);

        return user;
    }

    // Get user content
    @GetMapping("/{username}/content")
    public List<Content> getUserContent(@PathVariable String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        return contentRepository.findByOwnerId(username);
    }

    @PostMapping("/{username}/urlProfilePicture")
    public User setUserUrlProfilePicturePost(@PathVariable String username, @RequestBody String urlProfilePicture) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if urlProfilePicture is null, if it's, throw error
        if (urlProfilePicture == null) {
            throw new IllegalArgumentException("urlProfilePicture cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setUrlProfilePicture(urlProfilePicture);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/urlCoverPicture")
    public User setUserUrlCoverPicturePost(@PathVariable String username, @RequestBody String urlCoverPicture) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if urlCoverPicture is null, if it's, throw error
        if (urlCoverPicture == null) {
            throw new IllegalArgumentException("urlCoverPicture cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setUrlCoverPicture(urlCoverPicture);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/description")
    public User setUserDescriptionPost(@PathVariable String username, @RequestBody String description) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if description is null, if it's, put an empty string
        if (description == null) {
            description = "";
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setDescription(description);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/motto")
    public User setUserMottoPost(@PathVariable String username, @RequestBody String motto) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if motto is null, if it's, put an empty string
        if (motto == null) {
            motto = "";
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setMotto(motto);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/showNSFW")
    public User setUserShowNSFW(@PathVariable String username, @RequestBody boolean showNSFW) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setShowNSFW(showNSFW);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/ofAge")
    public User setUserOfAge(@PathVariable String username, @RequestBody boolean ofAge) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setOfAge(ofAge);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/isMuted")
    public User setUserIsMuted(@PathVariable String username, @RequestBody boolean isMuted) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setIsMuted(isMuted);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/{username}/canUpload")
    public User setUserCanUploadPost(@PathVariable String username, @RequestBody boolean canUpload) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // check if present, otherwise throw exception
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        user.setCanUpload(canUpload);
        userRepository.save(user);

        return user;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {

        // check if present, otherwise throw exception
        userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        userRepository.deleteById(username);
    }

    @PatchMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User user) {

        // check if present, otherwise throw exception
        userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));

        userRepository.save(user);
    }


}
