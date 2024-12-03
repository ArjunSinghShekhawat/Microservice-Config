package com.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found exception !!");
    }
    public ResourceNotFoundException(String mgs){
        super(mgs);
    }
}
