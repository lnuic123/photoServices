package com.example.photoService.domain;

public class PhotoDetails {
    private String name;
    private String description;
    private String author;

    private String imgUrl;
    private Double width;
    private Double height;
    private String[] tags;

    public PhotoDetails(String name, String description, String author, String imgUrl, Double width, Double height, String[] tags) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.imgUrl = imgUrl;
        this.width = width;
        this.height = height;
        this.tags = tags;
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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
