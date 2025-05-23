package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONRecipeConverter {
    public static Recipe jsonToRecepie(String recepieInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        return gsonResult.fromJson(recepieInJSON, Recipe.class);
    }

    public static String recepieToJson(Recipe recepie) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recepie);
    }
}
