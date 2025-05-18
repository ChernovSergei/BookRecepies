package controller;

import service.Recipe;

import java.util.List;

public interface RecepiesService {
    void save(Recipe recepie);

    List<Recipe> getAllRecepies();
}
