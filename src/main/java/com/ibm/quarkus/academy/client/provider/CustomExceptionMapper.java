package com.ibm.quarkus.academy.client.provider;

import com.ibm.quarkus.academy.client.exception.CustomException;
import com.ibm.quarkus.academy.client.exception.UnauthorizedException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof WebApplicationException) {
            Response originalErrorResponse = ((WebApplicationException) exception).getResponse();
            return Response.fromResponse(originalErrorResponse)
                    .entity(exception.getMessage())
                    .build();
        } else if (exception instanceof CustomException) {
            return Response.status(((CustomException) exception).getStatus())
                    .entity(((CustomException) exception).getResponseMessage())
                    .build();
        } else if (exception instanceof UnauthorizedException) {
            return Response.status(((UnauthorizedException) exception).getStatus())
                    .entity(((UnauthorizedException) exception).getResponseMessage())
                    .build();
        }
        return Response.serverError().entity("Internal Server Error").build();
    }
}
