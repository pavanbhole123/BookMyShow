package com.BookMyShow.Repository.Exception;

public class UserEmailNotFoundException extends RuntimeException{

    public UserEmailNotFoundException(String message) {
        super(message);
    }
}
