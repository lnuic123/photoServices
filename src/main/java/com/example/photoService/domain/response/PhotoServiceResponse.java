package com.example.photoService.domain.response;

import com.example.photoService.domain.PhotoServiceResponseStatus;

public class PhotoServiceResponse {
    private PhotoServiceResponseStatus responseStatus;
    private String responseMessage;
    private Object response;

    public PhotoServiceResponse(PhotoServiceResponseStatus responseStatus, String responseMessage) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    public PhotoServiceResponse(PhotoServiceResponseStatus responseStatus, String responseMessage, Object response) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.response = response;
    }

    public PhotoServiceResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(PhotoServiceResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
