package service;

import java.util.HashMap;

public class RecipeBook {
    private HashMap<Integer, Recipe> recipes = new HashMap<>();

    public void setRecipes(HashMap<Integer, Recipe> recipes) {
        this.recipes = recipes;
    }

    public HashMap<Integer, Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("RecipeBook{ recipes=");
        recipes.entrySet().forEach(r -> result.append(r.toString()));
        result.append("}");
        return result.toString();
    }
}
