package cookbook.domainservice.recipe_service.service_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import cookbook.domainservice.recipe_service.api.models.ActiveRecipeIngredient;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSearchResultView;
import cookbook.domainservice.recipe_service.service_impl.mappers.RecipeMapper;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {

    // After test passes, check if @Mock would work better
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeMapper recipeMapper;

    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
    RecipeServiceImpl recipeServiceImpl;

    @BeforeEach
    public void setup(){
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository, recipeMapper);
    }
    
    @Test
    @DisplayName("Test Service-level search by keyword")
    void testSearchRecipesByKeyword() {
        
        // Mock data for search return
        RecipeSearchResultView recipeSearchResultView = factory.createProjection(RecipeSearchResultView.class);
        recipeSearchResultView.setName("123");
        recipeSearchResultView.setId(123);
        recipeSearchResultView.setOwner(1);
        recipeSearchResultView.setAverageRating(3.5);
        recipeSearchResultView.setDescription("Description");

        List<RecipeSearchResultView> searchResults = new ArrayList<>();
        searchResults.add(recipeSearchResultView);
        // Mock repository method...
        Mockito.when(recipeRepository.fullTextRecipeSearchByKeyword("123"))
            .thenReturn(searchResults);
        // Mock Mapper method...
        // TODO: See if this can be place elsewhere and generalized. Ideally, not in a "BeforeEach"
        // Possibly in a nested test?
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

    @Nested
    @DisplayName("Given that there are 3 possible results")
    class testTopNToMRecipes {
        @BeforeEach
        void testTopNToMRecipesSetup() {
            RecipeCardView firstSearchRecipeCardView = createRecipeCardView(
                "First Recipe",
                1,
                0,
                5.0
            );
            RecipeCardView secondSearchRecipeCardView = createRecipeCardView(
                "Second Recipe",
                2,
                0,
                3.5
            );
            RecipeCardView thirdSearchRecipeCardView = createRecipeCardView(
                "Third Recipe",
                3,
                0,
                3.5
            );
            List<RecipeCardView> searchResults = new ArrayList<>();
            searchResults.add(firstSearchRecipeCardView);
            searchResults.add(secondSearchRecipeCardView);
            searchResults.add(thirdSearchRecipeCardView);

            Mockito.when(recipeRepository.findAllProjectedBy())
                .thenReturn(searchResults);
            
            Mockito.when(recipeMapper.recipeCardProjectionToModel(Mockito.anyList())).thenAnswer(new Answer<List<Recipe>>() {
                @Override
                public List<Recipe> answer(InvocationOnMock invocation) {
                    Object[] args = invocation.getArguments();
                    List<RecipeCardView> source = (List<RecipeCardView>) args[0];
                    List<Recipe> target = new ArrayList<>();
                    for (RecipeCardView searchResult : source) {
                        Recipe recipe = new Recipe();
                        recipe.setId(searchResult.getId());
                        recipe.setName(searchResult.getName());
                        recipe.setAverageRating(searchResult.getAverageRating());                    
                        target.add(recipe);
                    }
                    return target;
                }
            });
        }

        @Test
        @DisplayName("Then should only return first 2 results, if that is requestd")
        void testUpperWithinBounds() {
            Recipe expectedFirstResult = createRecipe(1, "First Recipe", null, null, 5.0);
            Recipe expectedSecondResult = createRecipe(2, "Second Recipe", null, null, 3.5);
            List<Recipe> expectedResult = new ArrayList<>();
            expectedResult.add(expectedFirstResult);
            expectedResult.add(expectedSecondResult); 

            List<Recipe> actualResult = recipeServiceImpl.topNToMRecipes(0, 2);
            assertThat(actualResult).isEqualTo(expectedResult);
        }
        
        @Test
        @DisplayName("Then should return all 3 if upper is greater than results")
        void testUpperOutOfBounds() {
            Recipe expectedFirstResult = createRecipe(1, "First Recipe", null, null, 5.0);
            Recipe expectedSecondResult = createRecipe(2, "Second Recipe", null, null, 3.5);
            Recipe expectedThirdResult = createRecipe(3, "Third Recipe", null, null, 3.5);
            List<Recipe> expectedResult = new ArrayList<>();
            expectedResult.add(expectedFirstResult);
            expectedResult.add(expectedSecondResult);
            expectedResult.add(expectedThirdResult); 

            List<Recipe> actualResult = recipeServiceImpl.topNToMRecipes(0, 5);
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("Then should return upto upperbound, if lower bound is negative")
        void testLowerOutOfBounds() {
            Recipe expectedFirstResult = createRecipe(1, "First Recipe", null, null, 5.0);
            Recipe expectedSecondResult = createRecipe(2, "Second Recipe", null, null, 3.5);
            List<Recipe> expectedResult = new ArrayList<>();
            expectedResult.add(expectedFirstResult);
            expectedResult.add(expectedSecondResult);            

            List<Recipe> actualResult = recipeServiceImpl.topNToMRecipes(-3, 2);
            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

    @Test
    @DisplayName("Given that I search for a lower bound greater than upper, then should thrown an index out of bounds exception")
    void testTopNToMThrowsIndexOutOfBounds() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> recipeServiceImpl.topNToMRecipes(1, 0));
    }

    // Private helper methods

    private RecipeCardView createRecipeCardView(String name, Integer id, Integer owner, Double rating){
        RecipeCardView card = factory.createProjection(RecipeCardView.class);
        card.setName(name);
        card.setId(id);
        card.setOwner(owner);
        card.setAverageRating(rating);
        return card;
    }

    private Recipe createRecipe(Integer id, String name, String description, Set<ActiveRecipeIngredient> steps, Double averageRating) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setAverageRating(averageRating);
        recipe.setSteps(steps);
        return recipe;
    }
}
