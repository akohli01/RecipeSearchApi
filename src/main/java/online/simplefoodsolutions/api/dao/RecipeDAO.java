package online.simplefoodsolutions.api.dao;

import online.simplefoodsolutions.api.domain.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.Collection;

@Stateless
public class RecipeDAO {

	@PersistenceContext
    EntityManager entityManager;

    public Collection<Recipe> getByKeyword(String keyword) {
        TypedQuery<Recipe> typedQuery = entityManager.createNamedQuery("Recipe.findByKeyword", Recipe.class);
        typedQuery.setParameter("title", "%" + keyword + "%");
        System.out.println(typedQuery.getResultList());
        return typedQuery.getResultList();
    }

    public Recipe getRecipeByID(Long id){
        return entityManager.find(Recipe.class, id);
    }

}
