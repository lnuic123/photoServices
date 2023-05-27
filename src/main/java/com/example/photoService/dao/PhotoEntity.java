package com.example.photoService.dao;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PHOTO_DETAILS")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;
    private String name;
    private String description;
    private String author;

    private String imgUrl;
    private Double width;
    private Double height;
    @ManyToMany
    @JoinTable(
            name = "PHOTO_TAG",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<PhotoTag> photoTags;

    public PhotoEntity() {
    }

    public PhotoEntity(Double id, String name, String description, String author, String imgUrl, Double width, Double height, Set<PhotoTag> photoTags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.imgUrl = imgUrl;
        this.width = width;
        this.height = height;
        this.photoTags = photoTags;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Set<PhotoTag> getPhotoTags() {
        return photoTags;
    }

    public void setPhotoTags(Set<PhotoTag> photoTags) {
        this.photoTags = photoTags;
    }
}
