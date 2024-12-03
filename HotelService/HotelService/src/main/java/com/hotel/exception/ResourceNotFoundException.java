package com.hotel.exception;

import jakarta.validation.constraints.NotBlank;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found exception !!");
    }
    public ResourceNotFoundException(String mgs){
        super(mgs);
    }
}
