package com.example.photoService.dao;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PHOTO_TAG")
public class PhotoTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;
    private String name;
    @ManyToMany(mappedBy = "photoTags")
    private Set<PhotoEntity> photoEntities;

    public PhotoTag() {
    }

    public PhotoTag(Double id, String name, Set<PhotoEntity> photoEntities) {
        this.id = id;
        this.name = name;
        this.photoEntities = photoEntities;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhotoEntity> getPhotoEntities() {
        return photoEntities;
    }

    public void setPhotoEntities(Set<PhotoEntity> photoEntities) {
        this.photoEntities = photoEntities;
    }
}
