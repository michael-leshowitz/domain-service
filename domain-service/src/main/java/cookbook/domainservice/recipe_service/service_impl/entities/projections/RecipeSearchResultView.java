package cookbook.domainservice.recipe_service.service_impl.entities.projections;

public interface RecipeSearchResultView {
    String getName();

    Integer getId();

    Integer getOwner();

    Double getAverageRating();

    String getDescription();

    // Setters to facilitate testing
    void setName(String name);

    void setId(Integer id);

    void setOwner(Integer owner);

    void setAverageRating(Double averageRating);

    void setDescription(String description);
}
