package com.javatraining.jooleprojectteam2.Exception;

public class ProjectDoesntExistException extends RuntimeException{
    public ProjectDoesntExistException(String message) {
        super(message);
    }
}
