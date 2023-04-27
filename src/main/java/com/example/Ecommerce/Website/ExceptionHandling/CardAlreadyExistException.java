package com.example.Ecommerce.Website.ExceptionHandling;

public class CardAlreadyExistException extends Exception{
    public CardAlreadyExistException(String message){
        super(message);
    }
}
