package com.javatraining.jooleprojectteam2.Exception;

public class ProductDoesntExistException extends RuntimeException{
    public ProductDoesntExistException(String message) {
        super(message);
    }
}
