package com.example.photoService.service.impl;

import com.example.photoService.dao.PhotoEntity;
import com.example.photoService.domain.PhotoDetails;
import com.example.photoService.domain.PhotoServiceResponseStatus;
import com.example.photoService.domain.request.UpdatePhotoRequest;
import com.example.photoService.domain.response.PhotoServiceResponse;
import com.example.photoService.repository.PhotoDetailsRepository;
import com.example.photoService.service.api.PhotoServiceApi;
import liquibase.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.photoService.service.util.PhotoServiceHelper.*;

@Service
public class PhotoServiceImpl implements PhotoServiceApi {

    private final PhotoDetailsRepository photoDetailsRepository;

    @Autowired
    public PhotoServiceImpl(PhotoDetailsRepository photoDetailsRepository) {
        this.photoDetailsRepository = photoDetailsRepository;
    }

    @Override
    public PhotoServiceResponse savePhoto(PhotoDetails details) {
        photoDetailsRepository.save(mapPhotoDetailsToPhotoEntity(details));
        return new PhotoServiceResponse(PhotoServiceResponseStatus.OK,
                "Photo saved successfully");
    }

    @Override
    public PhotoServiceResponse deletePhotoById(String id) {

        if (!isNumeric(id)) {
            return new PhotoServiceResponse(PhotoServiceResponseStatus.ERROR,
                    "Photo delete failed - Photo ID must be numeric");
        }
        PhotoEntity photoEntity = photoDetailsRepository.findById(Long.parseLong(id)).orElse(null);

        if (photoEntity == null) {
            return new PhotoServiceResponse(PhotoServiceResponseStatus.ERROR,
                    "Photo delete failed - Photo with " + id + " ID not found.");
        }

        photoDetailsRepository.delete(photoEntity);
        return new PhotoServiceResponse(PhotoServiceResponseStatus.OK,
                "Photo deleted successfully");
    }

    @Override
    public PhotoServiceResponse updatePhotoDetails(UpdatePhotoRequest updatePhotoRequest) {
        String message = validateUpdatePhotoRequest(updatePhotoRequest);
        if (!StringUtil.isEmpty(message)) {
            return new PhotoServiceResponse(PhotoServiceResponseStatus.ERROR, message);
        }

        PhotoEntity photoEntity = photoDetailsRepository.findById(Long.parseLong(updatePhotoRequest.getId())).orElse(null);

        if (photoEntity == null) {
            return new PhotoServiceResponse(PhotoServiceResponseStatus.ERROR,
                    "Photo update failed - Photo with " + updatePhotoRequest.getId() + " ID not found.");
        }

        photoDetailsRepository.save(updatePhotoValues(updatePhotoRequest.getPhotoDetails(), photoEntity));

        return new PhotoServiceResponse(PhotoServiceResponseStatus.OK,
                "Photo " + updatePhotoRequest.getId() + " updated successfully");
    }

    private PhotoEntity updatePhotoValues(PhotoDetails photoDetails, PhotoEntity photoEntity) {
        if (!StringUtil.isEmpty(photoDetails.getAuthor())) photoEntity.setAuthor(photoDetails.getAuthor());
        if (!StringUtil.isEmpty(photoDetails.getDescription())) photoEntity.setAuthor(photoDetails.getDescription());
        if (!StringUtil.isEmpty(photoDetails.getName())) photoEntity.setAuthor(photoDetails.getName());

        if (photoDetails.getHeight() != null) photoEntity.setHeight(photoDetails.getHeight());
        if (photoDetails.getWidth() != null) photoEntity.setWidth(photoDetails.getWidth());


        return photoEntity;
    }
}
