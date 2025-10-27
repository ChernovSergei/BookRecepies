package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RecipesJSONFileStorage implements RecipesRepository {
    private final Path fullDirectory;
    private RecipeBook recipeBook = new RecipeBook();

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

    public void readRecipeBook() {
        String recipeBookInJSON;
        try {
            recipeBookInJSON = Files.readString(this.fullDirectory);
            recipeBook = JSONRecipeBookConverter.jsonToRecipeBook(recipeBookInJSON);
            if (recipeBook == null) {
                recipeBook = new RecipeBook();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRecipeBook() {
        String JSONRecipeBook = JSONRecipeBookConverter.recipeBookToJson(recipeBook);
        try {
            Files.writeString(fullDirectory, JSONRecipeBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Recipe recipe) {
        readRecipeBook();
        int newID = 1;
        while (recipeBook.getRecipes().containsKey(newID)) {
            newID++;
        }
        recipe.setId(newID);
        recipeBook.getRecipes().put(newID, recipe);
        writeRecipeBook();
    }

    @Override
    public void update(Recipe recipe) {
        readRecipeBook();
        recipeBook.getRecipes().replace(recipe.getId(), recipe);
        writeRecipeBook();
    }

    @Override
    public List<Recipe> getAll() {
        readRecipeBook();
        return recipeBook.getRecipes().values().stream().toList();
    }

    @Override
    public Map<Integer, String> getAllRecipeNames() {
        readRecipeBook();
        Map<Integer, String> result =
                recipeBook.getRecipes()
                        .values()
                        .stream()
                        .collect(Collectors.toMap(Recipe::getId, Recipe::getName));
        return result;
    }

    @Override
    public Recipe getRecipe(int id) {
        readRecipeBook();
        return recipeBook.getRecipes().get(id);
    }

    @Override
    public void deleteRecipe(int id) {
        readRecipeBook();
        recipeBook.getRecipes().remove(id);
        writeRecipeBook();
    }

    public static void main(String[] args) throws IOException {
        RecipesJSONFileStorage storage = new RecipesJSONFileStorage("path", "Recepies.txt");
        storage.readRecipeBook();
        Tool knife1 = new Tool("knife");
        Product carrot = new Product("carrot", "vegetable");
        Action cut = new Action("cut");
        RecipeStep step1 = new RecipeStep(carrot, knife1, cut);
        Tool pan = new Tool("pan");
        Action fry = new Action("fry");
        RecipeStep step2 = new RecipeStep(carrot, pan, fry);
        Recipe recipe = new Recipe("borsh");
        List<RecipeStep> steps = new LinkedList<>();
        steps.add(step1);
        steps.add(step2);
        recipe.setSteps(steps);
        storage.save(recipe);
        storage.getAll().forEach(r -> System.out.println(r));

        System.out.println(storage.getRecipe(1));
    }
}
