package cookbook.domainservice.recipe_service.api;

import java.util.List;

import cookbook.domainservice.recipe_service.api.models.Recipe;

public interface RecipeService {
    public List<Recipe> searchRecipesByKeyword(String keyword);
    public List<Recipe> topNToMRecipes(Integer lowerBound, Integer upperBound)throws IndexOutOfBoundsException;
}
