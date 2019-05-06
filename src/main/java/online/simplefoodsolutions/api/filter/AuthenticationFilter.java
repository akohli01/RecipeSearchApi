package online.simplefoodsolutions.api.filter;


import online.simplefoodsolutions.api.dao.APIKeyDAO;
import online.simplefoodsolutions.api.dao.APIKeyImplementation;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class AuthenticationFilter implements ContainerRequestFilter
{
    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException
    {
        final MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();

        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        APIKeyDAO apiKeyDAO = new APIKeyImplementation();

        if (!apiKeyDAO.isAPIKeyCorrect(authorization.get(0)))
        {
            containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Unauthorized access").build());
            return;
        }

        System.out.println(authorization.get(0));

    }
}
