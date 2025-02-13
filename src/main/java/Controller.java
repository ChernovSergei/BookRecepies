import java.io.IOException;
import java.util.List;

public class Controller {
    private final ReceiptsJSONFileStorage dataSaver;
    //ReceiptsJSONFileStorage storage = new ReceiptsJSONFileStorage();
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    //Low responsibilities shouldn't be located at upper level
    //High responsibilities shouldn't be located at lower level
    //Try to keep hierarhy from upper to lower
    //Learn throw new RuntimeException
    //TODO: - check short cut for Intelijj to move methods inside the class
    //TODO: Add check - if currentRecepie == null
    //TODO: Modify the application for future expansion to save/ read Users' data
    //TODO: Modify the application for future expansion to save/ read data in XML
    //TODO: How fight the evil row #6

    public Controller() {
        try {
            this.dataSaver = new ReceiptsJSONFileStorage();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    public void saveRecepie(Recepie recepie) {
        dataSaver.saveData(recepie);
    }

    public List<Recepie> getAllRecepies() {
        return dataSaver.returnListOfRecepies();
    }
}
