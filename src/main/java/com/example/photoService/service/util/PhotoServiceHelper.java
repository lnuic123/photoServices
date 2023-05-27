package com.example.photoService.service.util;

import com.example.photoService.dao.PhotoEntity;
import com.example.photoService.domain.PhotoDetails;
import com.example.photoService.domain.request.UpdatePhotoRequest;

public class PhotoServiceHelper {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String validateUpdatePhotoRequest(UpdatePhotoRequest request){
        StringBuilder str = new StringBuilder();
        if(request.getPhotoDetails() == null){
            str.append("sdf");
        }
        return null;
    }

    public static PhotoEntity mapPhotoDetailsToPhotoEntity(PhotoDetails details){
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setDescription(details.getDescription());
        photoEntity.setName(details.getName());
        photoEntity.setTags(details.getTags());
        photoEntity.setImgUrl(details.getImgUrl());
        photoEntity.setHeight(details.getHeight());
        photoEntity.setWidth(details.getWidth());

        return photoEntity;
    }
}
