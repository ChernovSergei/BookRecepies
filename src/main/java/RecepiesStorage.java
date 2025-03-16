import java.util.List;

public interface RecepiesStorage {
    void save(Recepie recepie);

    List<Recepie> getAll();
}
