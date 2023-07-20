package cookbook.domainservice.recipe_service.service_impl.entities.projections;

public interface RecipeSearchResultView {
    RecipeCardView getRecipeCardView();

    String getDescription();
}
