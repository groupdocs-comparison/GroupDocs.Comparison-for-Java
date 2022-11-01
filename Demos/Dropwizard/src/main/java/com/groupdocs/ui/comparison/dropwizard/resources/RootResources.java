package com.groupdocs.ui.comparison.dropwizard.resources;

import javax.servlet.ServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Path(value = "/")
public class RootResources {

    @GET
    @Path(value = "/")
    public Response root(ServletResponse response) throws IOException, URISyntaxException {
        return Response.seeOther(new URI("/comparison")).build();
    }
}
