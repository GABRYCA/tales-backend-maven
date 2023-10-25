package eu.anonymousgca.talesbackendmaven.controllers;

import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.exceptions.ContentNotFoundException;
import eu.anonymousgca.talesbackendmaven.interfaces.ContentRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.custom.implementation.ContentRepositoryCustomImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController extends ContentRepositoryCustomImplementation {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @GetMapping("/{contentId}")
    public Content getContent(@PathVariable Long contentId) {

        if (contentId == null) {
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        return contentRepository.findById(contentId).orElseThrow();
    }

    @GetMapping("/user/{username}")
    public List<Content> getContentByUser(@PathVariable String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        return findByOwnerId(username);
    }

    @PostMapping
    public void addContent(@RequestBody Content content) {
        contentRepository.save(content);
    }

    @DeleteMapping("/{contentId}")
    public void deleteUser(@PathVariable Long contentId){

        if (contentId == null){
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        contentRepository.deleteById(contentId);
    }

    @PatchMapping("/{contentId}")
    public void updateContent(@PathVariable Long contentId, @RequestBody Content content) {

        if (contentId == null){
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        contentRepository.save(content);
    }
}
