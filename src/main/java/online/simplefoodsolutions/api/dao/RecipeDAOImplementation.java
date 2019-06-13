package online.simplefoodsolutions.api.dao;

import online.simplefoodsolutions.api.entity.Recipe;
import online.simplefoodsolutions.api.utility.SessionUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RecipeDAOImplementation implements RecipeDAO
{
    @Override
    public List<Recipe> getRecipeByTitle(String title)
    {
        Session session = SessionUtility.getSession();
        Query query = session.createQuery("from Recipe where title like ?1");
        query.setParameter(1, "%" + title + "%");
        List<Recipe> recipes = query.list();
        session.close();
        return recipes;
    }

    @Override
    public List<Recipe> getRecipeByTitleSortedAlphabetically(String title)
    {
        List<Recipe> recipes = getRecipeByTitle(title);
        recipes.sort((Recipe recipe1, Recipe recipe2) -> recipe1.getTitle().compareToIgnoreCase(recipe2.getTitle()));

        return recipes;
    }

    @Override
    public Recipe getRecipeByID(int id)
    {
        Session session = SessionUtility.getSession();
        Query query = session.createQuery("from Recipe where id = ?1");
        query.setParameter(1, id);
        Recipe recipe = (Recipe) query.uniqueResult();
        session.close();
        return recipe;
    }
}
