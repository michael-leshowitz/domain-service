package cookbook.domainservice.recipe_service.service_impl.entities.projections;

public interface RecipeCardView {
    String getName();

    Integer getId();

    Integer getOwner();

    Double getAverageRating();
}
