package online.simplefoodsolutions.api.boundary;

import online.simplefoodsolutions.api.dao.RecipeDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("recipes")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {
	
    @Inject
    private RecipeDAO recipeDAO;

    @GET
    @Path("search")
    public Response getRecipesByKeyword(@QueryParam("keyword") String keyword) {
        return Response.ok(recipeDAO.getByKeyword(keyword)).build();
    }

    @GET
    @Path("/{id}")
    public Response getRecipeByID(@PathParam("id") Long id) {
        return Response.ok(recipeDAO.getRecipeByID(id)).build();
    }
}
