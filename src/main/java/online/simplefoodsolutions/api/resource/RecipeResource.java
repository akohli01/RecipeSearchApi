package online.simplefoodsolutions.api.resource;

import online.simplefoodsolutions.api.dao.RecipeDAO;
import online.simplefoodsolutions.api.dao.RecipeDAOImplementation;
import online.simplefoodsolutions.api.entity.Recipe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/recipe/{name}")
public class RecipeResource
{

    @GET
    @Produces("application/json")
    public List<Recipe> getRecipeByID(@PathParam("name") String name)
    {
        RecipeDAO recipeDAO = new RecipeDAOImplementation();

        return recipeDAO.getRecipeByTitle(name);
    }
}
