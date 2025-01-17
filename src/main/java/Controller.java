import java.io.IOException;
import java.util.List;

public class Controller {
    private String recepieFormat = "%s the %s with a %s\n";
    private final RecepieConstructor recepieConstructor;
    private Recepie currentRecepie = null;

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

    //TODO Refactor get All Recepies. Think were store the method result
    public List<Recepie> getAllRecepies(String fileStorageDirectory, String fileStorageName) throws IOException {
        ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile(fileStorageDirectory, fileStorageName);
        return readerFromFile.returnListOfRecepies();
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
