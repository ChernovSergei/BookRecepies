package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONRecipeBookConverter {
    public static RecipeBook jsonToRecipeBook(String bookInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        return gsonResult.fromJson(bookInJSON, RecipeBook.class);
    }

    public static String recipeBookToJson(RecipeBook recipeBook) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recipeBook);
    }
}
