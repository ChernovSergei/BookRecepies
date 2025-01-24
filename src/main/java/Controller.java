import java.io.IOException;
import java.util.List;

public class Controller {
    private String recepiesStorageFileDirrectory = "path";
    private String recepiesStorageFileName = "Recepies.txt";
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    public List<Recepie> getAllRecepies() {
        List<Recepie> allRecepies = null;
        try {
            ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile(recepiesStorageFileDirrectory , recepiesStorageFileName);
            allRecepies = readerFromFile.returnListOfRecepies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allRecepies;
    }

    //TODO: Add check - if currentRecepie == null
    public void saveRecepie(Recepie recepie) {
        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(recepie);
        try {
            DataSaverToFile dataSaver = new DataSaverToFile(recepiesStorageFileDirrectory , recepiesStorageFileName);
            dataSaver.saveData(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
