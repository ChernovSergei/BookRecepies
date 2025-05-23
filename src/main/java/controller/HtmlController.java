package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {
    private RecipesStorage recipesStorage;

    public HtmlController(RecipesStorage recipesStorage) {
        this.recipesStorage = recipesStorage;
    }

    @GetMapping("/")
    public String index() {
        return "mainPage";
    }

    @GetMapping("/recipes")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipesStorage.getAll();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/recipe/{recipeID}")
    public String getRecipe(Model model, @PathVariable String recipeID) {
        List<Recipe> recipesValue = recipesStorage.getAll();
        Recipe recipe = recipesValue.stream().filter(r -> r.getName().equals(recipeID)).findFirst().orElseThrow();
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @GetMapping("/addRecipe")
    public String getNewRecipe() {
        return "addRecipe";
    }

    @PostMapping("/submitRecipe")
    public String postRecipe(@RequestParam String recipeName,
                             @RequestParam String toolName,
                             @RequestParam String productName,
                             @RequestParam String productType,
                             @RequestParam String actionName) {
        Recipe recipe = new Recipe(recipeName);
        Product product = new Product(productName, productType);
        Tool tool = new Tool(toolName);
        Action action = new Action(actionName);
        RecipeStep step = new RecipeStep(product,tool, action);
        List<RecipeStep> steps = new ArrayList<>();
        steps.add(step);
        recipe.setSteps(steps);
        recipesStorage.save(recipe);
        return "redirect:/addRecipe";
    }
}