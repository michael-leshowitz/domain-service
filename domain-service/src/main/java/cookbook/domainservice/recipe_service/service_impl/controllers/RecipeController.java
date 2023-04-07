package cookbook.domainservice.recipe_service.service_impl.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/recipe")
@RequiredArgsConstructor
public class RecipeController {    

    @NonNull private final RecipeService recipeService;
    
    @GetMapping(path="/query-by")
    public List<Recipe> fullTextByKeyword(@RequestParam String searchText) {
        return recipeService.searchRecipesByKeyword(searchText);
    }
    
}
