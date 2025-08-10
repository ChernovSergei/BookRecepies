package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.util.List;

@Controller
public class HtmlController {
    private RecipesRepository recipesRepository;

    public HtmlController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @GetMapping("/")
    public String index() {
        return "mainPage";
    }

    @GetMapping("/recipes")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipesRepository.getAll();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/recipe/{recipeID}")
    public String getRecipe(Model model, @PathVariable int recipeID) {
        Recipe recipe = recipesRepository.getRecipe(recipeID);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @GetMapping("/addRecipe")
    public String getNewRecipe() {
        return "addRecipe";
    }

    @PostMapping("/submitRecipe")
    public String postRecipe(@RequestBody Recipe recipe) {
        recipesRepository.save(recipe);
        return "redirect:/addRecipe";
    }
}