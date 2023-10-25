package eu.anonymousgca.talesbackendmaven.controllers;

import eu.anonymousgca.talesbackendmaven.entities.User;
import eu.anonymousgca.talesbackendmaven.exceptions.UserNotFoundException;
import eu.anonymousgca.talesbackendmaven.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

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
