package service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public interface RecipesRepository {
    void save(Recipe recepie);

    void update(Recipe recipe);

    List<Recipe> getAll();

    Map<Integer, String> getAllRecipeNames();

    Recipe getRecipe(int id);

    void deleteRecipe(int id);
}
