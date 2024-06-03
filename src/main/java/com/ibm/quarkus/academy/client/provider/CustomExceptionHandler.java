package com.ibm.quarkus.academy.client.provider;

import com.ibm.quarkus.academy.client.exception.CustomException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ResponseExceptionMapper<Exception> {
    @Override
    public Exception toThrowable(Response response) {
        if (response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
            return new CustomException("Hmm, it seems that something bad happened :(", 400);
        }
        return null;
    }
}
