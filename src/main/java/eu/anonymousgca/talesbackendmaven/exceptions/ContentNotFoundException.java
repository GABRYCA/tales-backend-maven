package eu.anonymousgca.talesbackendmaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Content not found")

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(Long contentId) {
        super("Content not found with ID: " + contentId);
    }
}
