import java.util.List;

public class Controller implements RecepiesService {
    private RecepiesStorage recepiesStorage;

    public Controller(RecepiesStorage recepiesStorage) {
        this.recepiesStorage = recepiesStorage;
    }
    //ReceiptsJSONFileStorage storage = new ReceiptsJSONFileStorage();
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    //RESTfull API - ???
    //Low responsibilities shouldn't be located at upper level
    //High responsibilities shouldn't be located at lower level
    //Try to keep hierarhy from upper to lower
    //Learn throw new RuntimeException
    //check short cuts for Intelijj to move methods inside the class
    //TODO: Modify the application for future expansion to save/ read Users' data
    //TODO: Modify the application for future expansion to save/ read data in XML
    //TODO: How fight the evil row #6
    //TODO: Fix try catch inside ReceiptsJSONFileStorage, methods must throw exceptions
    //TODO: Create constructor for ConsoleClient and accept
    //TODO: Install Visual Studio and add DeepSeek

    @Override
    public void save(Recepie recepie) {
        try {
            recepiesStorage.save(recepie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    public List<Recepie> getAllRecepies() {
        try {
            return recepiesStorage.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to read the receipts");
        }
    }
}
