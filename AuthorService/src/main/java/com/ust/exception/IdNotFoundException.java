package com.ust.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String s){
        super(s);
    }
}
