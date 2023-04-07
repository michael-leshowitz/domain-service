package cookbook.domainservice.recipe_service.service_impl.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;

import cookbook.domainservice.recipe_service.api.RecipeService;

@Configuration
// @Import(RecipeControllerConfig.class)
public class RecipeControllerConfig {
    
    public RecipeController recipeController(RecipeService recipeService) {
        return new RecipeController(recipeService);
    }
}
