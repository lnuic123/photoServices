package com.example.photoService.api;

import com.example.photoService.domain.PhotoDetails;
import com.example.photoService.domain.request.UpdatePhotoRequest;
import com.example.photoService.service.api.PhotoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.photoService.domain.response.PhotoServiceResponse;
@RestController
@RequestMapping(value = "/photo")
public class PhotoServiceRestApi {

    private final PhotoServiceApi photoServiceApi;

    @Autowired
    public PhotoServiceRestApi(PhotoServiceApi photoServiceApi) {
        this.photoServiceApi = photoServiceApi;
    }

    @PostMapping(value = "/save")
    public PhotoServiceResponse savePhoto(@RequestBody PhotoDetails photoDetails){
        return photoServiceApi.savePhoto(photoDetails);
    }

    @GetMapping(value = "/delete/{id}")
    public PhotoServiceResponse deletePhoto(@RequestParam String id){
        return photoServiceApi.deletePhotoById(id);
    }

    @PostMapping(value = "/updatePhoto")
    public PhotoServiceResponse updatePhoto(@RequestBody UpdatePhotoRequest updatePhotoRequest){
        return photoServiceApi.updatePhotoDetails(updatePhotoRequest);
    }

}
