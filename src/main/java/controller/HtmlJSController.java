package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Recipe;
import service.RecipesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HtmlJSController {
    private RecipesRepository recipesRepository;

    public HtmlJSController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/recipes")
    public List<Recipe> getAllRecipes() {
        return recipesRepository.getAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/recipeNames")
    public Map<Integer, String> getAllRecipeNames() {
        return recipesRepository.getAllRecipeNames();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/delete/recipe/{id}")
    public void deleteRecipe(@PathVariable("id") int id) {
        recipesRepository.deleteRecipe(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/get/recipe/{id}")
    public Recipe getRecipe(@PathVariable("id") int id) {
        return recipesRepository.getRecipe(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/save/recipe")
    public ResponseEntity<Map<String, String>> saveRecipe(@RequestBody Recipe recipe) {
        recipesRepository.save(recipe);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Recipe saved successfully");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/update/recipe")
    public ResponseEntity<Map<String, String>> updateRecipe(@RequestBody Recipe recipe) {
        recipesRepository.update(recipe);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Recipe updated successfully");
        return ResponseEntity.ok(response);
    }
}
