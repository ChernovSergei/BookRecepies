package controller;

import service.Recepie;

import java.util.List;

public interface RecepiesService {
    void save(Recepie recepie);

    List<Recepie> getAllRecepies();
}
