package service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RecepiesStorage {
    void save(Recepie recepie);

    List<Recepie> getAll();
}
