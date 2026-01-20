package com.boot.billing_software.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
