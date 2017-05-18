package edu.hm.shareit.auth.api;

import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.service.AuthService;
import edu.hm.shareit.auth.service.AuthServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
@Path("/auth")
public class Api {

    private final AuthService authService;

    public Api() {
        this.authService = new AuthServiceImpl();
    }

    public Api(AuthService authService) {
        this.authService = authService;
    }

    @POST
    @Path("/signup")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signup(User user) {
        return null;
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        return null;
    }

    @GET
    @Path("/logout/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@PathParam("username") String username) {
        return null;
    }

    @POST
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validate(String jwtToken) {
        return null;
    }
}
