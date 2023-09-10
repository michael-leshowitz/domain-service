package cookbook.domainservice.recipe_service.service_impl.entities.projections;

public interface RecipeCardView {
    String getName();

    Integer getId();

    Integer getOwner();

    Double getAverageRating();

    // Setters to facilitate testing

    void setName(String name);
    void setId(Integer id);
    void setOwner(Integer ownerId);
    void setAverageRating(Double rating);
}
