package service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RecipesRepository {
    void save(Recipe recepie);

    List<Recipe> getAll();

    Recipe getRecipe(int id);
}
