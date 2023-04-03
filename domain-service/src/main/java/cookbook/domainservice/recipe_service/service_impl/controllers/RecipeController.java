package cookbook.domainservice.recipe_service.service_impl.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cookbook.domainservice.recipe_service.service_impl.entities.Recipe;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;

@Controller
@RequestMapping(path="/recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping(path="/query-by")
    public List<Recipe> fullTextByKeyword(@RequestParam String searchText) {
        // TODO: refactor to use service
        return recipeRepository.fullTextByKeyword(searchText);
    }
    
}
