package com.example.Ecommerce.Website.ExceptionHandling;

public class ProductOutOfStockException extends Exception{
    public ProductOutOfStockException(String message){
        super(message);
    }
}
