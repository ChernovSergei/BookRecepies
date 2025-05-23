package controller;

import service.Recipe;
import service.RecipesStorage;

import java.util.List;

//@RestController
//@RequestMapping("/api")
public class RecipesAPIController implements RecepiesService {
    private RecipesStorage recipesStorage;

    public RecipesAPIController(RecipesStorage recipesStorage) {
        this.recipesStorage = recipesStorage;
    }

    //@Override
    public void save(Recipe recepie) {
        try {
            recipesStorage.save(recepie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    //@GetMapping("/recepies")
    public List<Recipe> getAllRecepies() {
        try {
            return recipesStorage.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to read the receipts");
        }
    }
}
