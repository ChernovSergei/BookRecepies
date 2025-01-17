import java.io.IOException;
import java.util.List;

public class Controller {
    private final RecepieConstructor recepieConstructor;
    private Recepie currentRecepie = null;
    private List<Recepie> recepies = null;

    public Controller() {
        this.recepieConstructor = new RecepieConstructor();
    }

    public void createReceipe(String recepieName) {
        currentRecepie = recepieConstructor.createRecepie(recepieName);
    }

    public void addRecepieStep(String product, String productType, String tool, String action) {
        RecepieStep recepieStep = recepieConstructor.createRecepieStep(product, productType, tool, action);
        recepieConstructor.addRecepieStep(recepieStep);
    }

    public List<Recepie> getAllRecepies(String fileStorageDirectory, String fileStorageName) {
        try {
            ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile(fileStorageDirectory, fileStorageName);
            recepies = readerFromFile.returnListOfRecepies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recepies;
    }

    //TODO Add check - if currentRecepie == null
    public void trySaveRecepie(String fileStorageDirectory, String fileStorageName) {
        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(currentRecepie);
        try {
            DataSaverToFile dataSaver = new DataSaverToFile(fileStorageDirectory, fileStorageName);
            dataSaver.saveData(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
