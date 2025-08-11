package controller;

import service.Recipe;
import service.RecipesRepository;

import java.util.List;

//@RestController
//@RequestMapping("/api")
public class RecipesAPIController implements RecepiesService {
    private RecipesRepository recipesRepository;

    public RecipesAPIController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    //@Override
    public void save(Recipe recepie) {
        try {
            recipesRepository.save(recepie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    //@GetMapping("/recepies")
    public List<Recipe> getAllRecepies() {
        try {
            return recipesRepository.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to read the receipts");
        }
    }
}
