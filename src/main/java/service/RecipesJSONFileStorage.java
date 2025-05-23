package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RecipesJSONFileStorage implements RecipesStorage {
    private final Path fullDirectory;

    public RecipesJSONFileStorage(@Value("${storage.directory}") String storageDirectory, @Value("${storage.path}") String storageName) throws IOException {
        Path directory = Path.of(storageDirectory);
        String fullDirectory = directory + "/" + storageName;
        this.fullDirectory = Path.of(fullDirectory);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        if (!Files.exists(this.fullDirectory)) {
            Files.createFile(this.fullDirectory);
        }
    }

    @Override
    public void save(Recipe recepie) {
        recepie.setId(getLastId());
        String JSONRecepie = JSONRecipeConverter.recepieToJson(recepie);
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(this.fullDirectory.toFile(), true)))) {
            output.println(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipe> getAll() {
        List<Recipe> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Files.readString(this.fullDirectory)).useDelimiter("\n");
            while(scanner.hasNext()) {
                result.add(JSONRecipeConverter.jsonToRecepie(scanner.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Recipe getRecipe(int id) {
        Recipe result = null;
        for (Recipe recipe : getAll()) {
            if (id == recipe.getId()) {
                result = recipe;
            }
        }
        return result;
    }

    public void deleteRecipe(int id) {
        try {
            List<String> recipes = Files.readAllLines(fullDirectory);
            for (int i = 0; i < recipes.size(); i++) {
                if (recipes.get(i).startsWith("{\"id\":" + id)) {
                    recipes.remove(i);
                }
            }
            Files.write(fullDirectory, recipes, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLastId() {
        int result = -1;
        List<Recipe> recepieList = getAll();
        for (Recipe r : recepieList) {
            if (result < r.getId()) {
                result = r.getId();
            }
        }
        return result == -1 ? 0 : ++result;
    }

    public void saveAll(List<Recipe> recepies) {
        for (Recipe recepie : recepies) {
            save(recepie);
        }
    }
}
