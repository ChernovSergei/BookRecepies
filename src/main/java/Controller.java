import java.io.IOException;
import java.util.List;

public class Controller {
    private String recepieFormat = "%s the %s with a %s\n";
    private final RecepieConstructor recepieConstructor;
    private List<Recepie> allRecepies;
    private String directory;
    private String fileName;

    public Controller() {
        this.recepieConstructor = new RecepieConstructor();
    }

    public void createReceipe(String recepieName) {
        recepieConstructor.createRecepie(recepieName);
    }

    public void addRecepieStep(String product, String productType, String tool, String action) {
        RecepieStep recepieStep = recepieConstructor.createRecepieStep(product, productType, tool, action);
        recepieConstructor.addRecepieStep(recepieStep);
    }

    public List<Recepie> getAllRecepies(String fileStorageDirectory, String fileStorageName) throws IOException {
        ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile(fileStorageDirectory, fileStorageName);
        return readerFromFile.returnListOfRecepies();
    }

    public void trySaveRecepie(Recepie recepie, String fileStorageDirectory, String fileStorageName) {
        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(recepie);
        try {
            DataSaverToFile dataSaver = new DataSaverToFile(fileStorageDirectory, fileStorageName);
            dataSaver.saveData(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
