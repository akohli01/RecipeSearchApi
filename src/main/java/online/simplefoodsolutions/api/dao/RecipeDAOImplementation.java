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
        query.setParameter(1, "% " + title + " %");
        List<Recipe> recipes = query.list();
        session.close();
        return recipes;
    }
}
