package com.boot.billing_software.exception;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message){
        super(message);
    }
}
