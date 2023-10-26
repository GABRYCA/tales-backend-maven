package eu.anonymousgca.talesbackendmaven.controllers;

import eu.anonymousgca.talesbackendmaven.entities.Comment;
import eu.anonymousgca.talesbackendmaven.entities.Content;
import eu.anonymousgca.talesbackendmaven.entities.Liked;
import eu.anonymousgca.talesbackendmaven.exceptions.ContentNotFoundException;
import eu.anonymousgca.talesbackendmaven.interfaces.CommentRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.ContentRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.LikedRepository;
import eu.anonymousgca.talesbackendmaven.interfaces.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    ///////////////////////////////////
    // Repositories
    ///////////////////////////////////

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikedRepository likedRepository;


    ///////////////////////////////////
    // GET endpoints
    ///////////////////////////////////

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

    @GetMapping("/{contentId}/comments")
    public List<Comment> getCommentsByContent(@PathVariable Long contentId) {

        if (contentId == null) {
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        return commentRepository.findByContentId(contentId);
    }

    @GetMapping("/{contentId}/likes")
    public List<Liked> getLikesByContent(@PathVariable Long contentId) {

        if (contentId == null) {
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        return likedRepository.findByIdContentId(contentId);
    }

    @GetMapping("/user/{username}")
    public List<Content> getContentByUser(@PathVariable String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        return contentRepository.findByOwnerId(username);
    }

    ///////////////////////////////////
    // POST endpoints
    ///////////////////////////////////

    @PostMapping
    public void addContent(@RequestBody Content content) {
        contentRepository.save(content);
    }

    ///////////////////////////////////
    // PATCH endpoints
    ///////////////////////////////////

    @PatchMapping("/{contentId}")
    public void updateContent(@PathVariable Long contentId, @RequestBody Content content) {

        if (contentId == null){
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        contentRepository.save(content);
    }

    ///////////////////////////////////
    // DELETE endpoints
    ///////////////////////////////////

    @DeleteMapping("/{contentId}")
    public void deleteUser(@PathVariable Long contentId){

        if (contentId == null){
            throw new IllegalArgumentException("Content ID cannot be null");
        }

        // Check if content found
        contentRepository.findById(contentId).orElseThrow(() -> new ContentNotFoundException(contentId));

        contentRepository.deleteById(contentId);
    }
}
