package online.simplefoodsolutions.api.dao;

import online.simplefoodsolutions.api.entity.Recipe;

import java.util.List;

public interface RecipeDAO
{
    public List<Recipe> getRecipeByTitle(String title);
}
