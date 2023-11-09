package eu.anonymousgca.talesbackendmaven.controllers;

import eu.anonymousgca.talesbackendmaven.entities.GalleryGroup;
import eu.anonymousgca.talesbackendmaven.interfaces.GalleryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gallery")
public class GalleryController {

    @Autowired
    private GalleryGroupRepository galleryGroupRepository;

    @GetMapping
    public List<GalleryGroup> getAllGalleryGroups() {
        return galleryGroupRepository.findAll();
    }
}
