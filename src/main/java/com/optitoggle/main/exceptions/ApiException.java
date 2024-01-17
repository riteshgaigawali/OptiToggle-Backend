package com.optitoggle.main.exceptions;

public class ApiException extends RuntimeException {

    public ApiException(String messege) {
        super(messege);
    }

    public ApiException() {
        super();
    }

}
