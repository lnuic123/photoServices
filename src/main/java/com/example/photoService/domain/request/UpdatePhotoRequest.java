package com.example.photoService.domain.request;

import com.example.photoService.domain.PhotoDetails;

public class UpdatePhotoRequest {
    private String Id;
    private PhotoDetails photoDetails;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public PhotoDetails getPhotoDetails() {
        return photoDetails;
    }

    public void setPhotoDetails(PhotoDetails photoDetails) {
        this.photoDetails = photoDetails;
    }
}
