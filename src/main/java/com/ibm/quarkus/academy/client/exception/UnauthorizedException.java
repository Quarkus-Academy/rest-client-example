package com.ibm.quarkus.academy.client.exception;

import jakarta.ws.rs.WebApplicationException;
import lombok.Getter;

public class UnauthorizedException extends RuntimeException {
    @Getter
    String responseMessage;
    @Getter
    int status;
    public UnauthorizedException(String message, int status) {
        super(message);
        this.responseMessage = message;
        this.status =status;
    }
}
