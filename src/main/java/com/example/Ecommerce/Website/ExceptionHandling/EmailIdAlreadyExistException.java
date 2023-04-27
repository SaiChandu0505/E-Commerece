package com.example.Ecommerce.Website.ExceptionHandling;

public class EmailIdAlreadyExistException extends Exception{

    public EmailIdAlreadyExistException(String message){
        super(message);
    }
}
