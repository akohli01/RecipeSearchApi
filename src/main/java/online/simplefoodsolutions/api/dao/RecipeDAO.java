package online.simplefoodsolutions.api.dao;

import online.simplefoodsolutions.api.entity.Recipe;

import java.util.List;

public interface RecipeDAO
{
    List<Recipe> getRecipeByTitle(String title);

    List<Recipe> getRecipeByTitleSortedAlphabetically(String title);

    Recipe getRecipeByID(int id);

}
