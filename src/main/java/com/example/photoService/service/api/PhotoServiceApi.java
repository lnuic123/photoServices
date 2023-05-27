package com.example.photoService.service.api;

import com.example.photoService.domain.PhotoDetails;
import com.example.photoService.domain.request.UpdatePhotoRequest;
import com.example.photoService.domain.response.PhotoServiceResponse;

public interface PhotoServiceApi {
    PhotoServiceResponse savePhoto(PhotoDetails details);

    PhotoServiceResponse deletePhotoById(String id);

    PhotoServiceResponse updatePhotoDetails(UpdatePhotoRequest updatePhotoRequest);
}
