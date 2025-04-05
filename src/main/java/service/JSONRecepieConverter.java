package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONRecepieConverter {
    public static Recepie jsonToRecepie(String recepieInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        return gsonResult.fromJson(recepieInJSON, Recepie.class);
    }

    public static String recepieToJson(Recepie recepie) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recepie);
    }
}
