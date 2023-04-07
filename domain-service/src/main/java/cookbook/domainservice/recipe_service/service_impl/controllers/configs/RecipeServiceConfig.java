package cookbook.domainservice.recipe_service.service_impl.controllers.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.service_impl.RecipeServiceImpl;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;

@Configuration
public class RecipeServiceConfig {
    @Bean
    public RecipeService recipeService(
        RecipeRepository recipeRepository
    ) {
        return new RecipeServiceImpl(recipeRepository);
    }
}
