package online.simplefoodsolutions.api.filter;


import online.simplefoodsolutions.api.dao.APIKeyDAO;
import online.simplefoodsolutions.api.dao.APIKeyImplementation;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

public class AuthenticationFilter implements ContainerRequestFilter
{
    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Override
    public void filter(ContainerRequestContext containerRequestContext)
    {
        final MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();

        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        APIKeyDAO apiKeyDAO = new APIKeyImplementation();

        try
        {
            if (authorization.get(0) == null || !apiKeyDAO.isAPIKeyCorrect(authorization.get(0)))
            {
                containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Cause:Incorrect API key").build());
            }
        } catch (NullPointerException exception)
        {
            containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Cause: No api key provided").build());
        }
    }
}
