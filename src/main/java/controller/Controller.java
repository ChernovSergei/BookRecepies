package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Recepie;
import service.RecepiesStorage;
import java.util.List;

@RestController
public class Controller implements RecepiesService {
    private RecepiesStorage recepiesStorage;

    public Controller(RecepiesStorage recepiesStorage) {
        this.recepiesStorage = recepiesStorage;
    }

    @Override
    public void save(Recepie recepie) {
        try {
            recepiesStorage.save(recepie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    @GetMapping
    public List<Recepie> getAllRecepies() {
        try {
            return recepiesStorage.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to read the receipts");
        }
    }
}
