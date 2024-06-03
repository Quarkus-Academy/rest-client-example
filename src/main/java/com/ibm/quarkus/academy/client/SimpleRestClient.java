package com.ibm.quarkus.academy.client;

import java.util.UUID;

import com.ibm.quarkus.academy.dto.UserDto;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.rest.client.reactive.NotBody;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(configKey = "simple-rest-client")
@Path("/api/users")
@ClientHeaderParam(name = "X-Domain", value = "domain-from-annotation")
@ClientHeaderParam(name = "X-Domain-From-Properties", value = "${rest.client.domain}")
public interface SimpleRestClient {

    @GET
    @Path("{id}")
    Response user(@PathParam("id") String id, @QueryParam("omit-birthdate") boolean omitId);

    @POST
    @ClientHeaderParam(name = "X-Request-Id", value = "{requestId}")
    @ClientHeaderParam(name = "X-Custom-Header-Param", value = "{custom}")
    Response post(UserDto userDto,
                  @HeaderParam("X-Custom-Header") String customHeader,
                  @NotBody String custom);

    @PUT
    Response put(UserDto userDto);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") String id);

    default String requestId() {
        return UUID.randomUUID().toString();
    }

}
