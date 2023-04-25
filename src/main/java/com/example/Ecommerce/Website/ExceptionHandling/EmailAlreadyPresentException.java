package com.example.Ecommerce.Website.ExceptionHandling;

public class EmailAlreadyPresentException extends Exception{

    public EmailAlreadyPresentException(String message){
        super(message);
    }
}
