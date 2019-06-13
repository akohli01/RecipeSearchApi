package online.simplefoodsolutions.api.resource;

import online.simplefoodsolutions.api.dao.RecipeDAO;
import online.simplefoodsolutions.api.dao.RecipeDAOImplementation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/recipe")
public class RecipeResource
{
    @GET
    @Path("/title/{name}")
    @Produces("application/json")
    public Response getRecipeByTitle(@PathParam("name") String name, @Context UriInfo info)
    {
        RecipeDAO recipeDAO = new RecipeDAOImplementation();

        if (info.getQueryParameters().getFirst("sorted") != null)
            return Response.ok(recipeDAO.getRecipeByTitleSortedAlphabetically(name), MediaType.APPLICATION_JSON).build();

        return Response.ok(recipeDAO.getRecipeByTitle(name), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces("application/json")
    public Response getRecipeByID(@PathParam("id") int id, @Context UriInfo info)
    {
        RecipeDAO recipeDAO = new RecipeDAOImplementation();

        return Response.ok(recipeDAO.getRecipeByID(id), MediaType.APPLICATION_JSON).build();
    }
}
