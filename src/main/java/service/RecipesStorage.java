package service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RecipesStorage {
    void save(Recipe recepie);

    List<Recipe> getAll();
}
