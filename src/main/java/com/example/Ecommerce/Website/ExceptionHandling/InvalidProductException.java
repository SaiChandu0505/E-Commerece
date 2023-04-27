package com.example.Ecommerce.Website.ExceptionHandling;

public class InvalidProductException extends Exception{
    public InvalidProductException(String message){
        super(message);
    }
}
