package com.ibm.quarkus.academy.resource;

import com.ibm.quarkus.academy.client.SimpleRestClient;
import com.ibm.quarkus.academy.dto.UserDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/api/users")
public class UsersResource {

    @RestClient
    SimpleRestClient simpleRestClient;

    @GET
    @Path("{id}")
    public Response user(@PathParam("id") String id, @QueryParam("omit-birthdate") boolean omitBirthdate) {
        return simpleRestClient.user(id, omitBirthdate);
    }

    @POST
    public Response save(UserDto userDto) {
        return simpleRestClient.post(userDto, "custom-header-value", "custom-header-param");
    }

    @PUT
    public Response update(UserDto userDto) {
        return simpleRestClient.put(userDto);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        return simpleRestClient.delete(id);
    }
}
