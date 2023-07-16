package cookbook.domainservice.recipe_service.service_impl.entities.projections;

public interface RecipeSnippetView {
    String getName();

    Integer getId();

    Integer getOwner();

    RecipeRatingView getRating();
}
