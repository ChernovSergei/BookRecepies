import java.io.IOException;
import java.util.List;

public class Controller {
    //ReceiptsJSONFileStorage storage = new ReceiptsJSONFileStorage();
    private String recepiesStorageFileDirrectory = "path"; //Evil row
    private String recepiesStorageFileName = "Recepies.txt";
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    //Low responsibilities shouldn't be located at upper level
    //High responsibilities shouldn't be located at lower level
    //Try to keep hierarhy from upper to lower
    //Learn throw new RuntimeException
    //TODO: - check short cut for Intelijj to move methods inside the class
    //TODO: Add check - if currentRecepie == null
    //TODO: Storage file location and name are defined in Controller class. Move storage file data to another class
    //TODO: saveRecepie knows about JSON format while getAllRecepies doesn't know
    //TODO: Modify the application for future expansion to save/ read Users' data
    //TODO: Modify the application for future expansion to save/ read data in XML
    //TODO: How fight the evil row #6
    public void saveRecepie(Recepie recepie) {
        //storage.saveRecepie(recepie);

        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(recepie);
        try {
            ReceiptsJSONFileStorage dataSaver = new ReceiptsJSONFileStorage(recepiesStorageFileDirrectory , recepiesStorageFileName);
            dataSaver.saveData(JSONRecepie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sorry!!! Unable to save a recepie");
        }
    }

    public List<Recepie> getAllRecepies() {
        //return storage.readRecepies();

        List<Recepie> allRecepies = null;
        try {
            ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile(recepiesStorageFileDirrectory , recepiesStorageFileName);
            allRecepies = readerFromFile.returnListOfRecepies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allRecepies;
    }
}
