package com.ibm.quarkus.academy.client.exception;

import lombok.Getter;

public class CustomException extends RuntimeException {

    @Getter
    String responseMessage;
    @Getter
    int status;

    public CustomException(String message, int status) {
        super(message);
        this.responseMessage = message;
        this.status =status;
    }

}
