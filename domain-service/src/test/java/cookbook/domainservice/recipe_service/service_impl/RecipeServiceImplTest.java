package cookbook.domainservice.recipe_service.service_impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
// import org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSearchResultView;
import cookbook.domainservice.recipe_service.service_impl.mappers.RecipeMapper;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;

public class RecipeServiceImplTest {

    // After test passes, check if @Mock would work better
    private RecipeRepository recipeRepository = Mockito.mock(RecipeRepository.class);
    private RecipeMapper recipeMapper = Mockito.mock(RecipeMapper.class);

    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
    @Test
    @DisplayName("This is the description of the test")
    void testSearchRecipesByKeyword() {
        RecipeServiceImpl recipeServiceImpl = new RecipeServiceImpl(recipeRepository, recipeMapper);
        
        // Mock data for search return
        RecipeSearchResultView recipeSearchResultView123 = factory.createProjection(RecipeSearchResultView.class);
        recipeSearchResultView123.setName("123");
        recipeSearchResultView123.setId(123);
        recipeSearchResultView123.setOwner(1);
        recipeSearchResultView123.setAverageRating(3.5);
        recipeSearchResultView123.setDescription("Description");

        List<RecipeSearchResultView> searchResult = new ArrayList<>();
        searchResult.add(recipeSearchResultView123);
        // Mock repository method...
        Mockito.when(recipeRepository.fullTextRecipeSearchByKeyword("123"))
            .thenReturn(searchResult);
        // Mock Mapper method...
        Mockito.when(recipeMapper.recipeSearchProjectionToModel(Mockito.anyList())).thenAnswer(new Answer<List<Recipe>>() {
            @Override
            public List<Recipe> answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                List<RecipeSearchResultView> source = (List<RecipeSearchResultView>) args[0];
                List<Recipe> target = new ArrayList<>();
                for (RecipeSearchResultView searchResult : source) {
                    Recipe recipe = new Recipe();
                    recipe.setId(searchResult.getId());
                    recipe.setName(searchResult.getName());
                    recipe.setAverageRating(searchResult.getAverageRating());
                    recipe.setDescription(searchResult.getDescription());
                    target.add(recipe);
                }
                return target;
            }
        });

        Recipe expectedRecipe1 = new Recipe();
        expectedRecipe1.setId(123);
        expectedRecipe1.setName("123");
        expectedRecipe1.setAverageRating(3.5);
        expectedRecipe1.setDescription("Description");

        List<Recipe> expectedResult = new ArrayList<>();
        expectedResult.add(expectedRecipe1);

        List<Recipe> actualResult = recipeServiceImpl.searchRecipesByKeyword("123");

        assertThat(actualResult).isEqualTo(expectedResult);        
    }

    @Test
    void testTopNToMRecipes() {

    }
}
