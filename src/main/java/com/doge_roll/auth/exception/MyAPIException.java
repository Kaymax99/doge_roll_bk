package com.doge_roll.auth.exception;

import org.springframework.http.HttpStatus;

public class MyAPIException extends RuntimeException {
	
	private HttpStatus status;
    private String statusText;
    
    public MyAPIException(HttpStatus status, String message) {
        this.status = status;
        this.statusText = message;
    }

    public MyAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.statusText = message1;
    }
    
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return statusText;
    }

}
