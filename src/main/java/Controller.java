import java.io.IOException;
import java.util.List;

public class Controller {
    private String recepieFormat = "%s the %s with a %s\n";
    private final RecepieConstructor recepieConstructor;

    public Controller() {
        this.recepieConstructor = new RecepieConstructor();
    }

    public void createReceipe() {
        recepieConstructor.createRecepie(ConsoleClient.requestRecepieName());
    }

    public RecepieStep createRecepieStep() {
        String action = ConsoleClient.requestActionName();
        String tool = ConsoleClient.requestToolName();
        String productType = ConsoleClient.requestProductType();
        String product = ConsoleClient.requestProductName();
        return recepieConstructor.createRecepieStep(product, productType, tool, action);
    }

    public void addRecepieStep(RecepieStep recepieStep) {
        recepieConstructor.addRecepieStep(recepieStep);
    }

    public List<Recepie> getAllRecepies() throws IOException {
        ReceiptsReaderFromFile readerFromFile = new ReceiptsReaderFromFile("path/path", "text.txt");
        return readerFromFile.returnListOfRecepies();
    }

    public void trySaveRecepie(Recepie recepie) {
        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(recepie);
        try {
            DataSaverToFile dataSaver = new DataSaverToFile("path/path/", "test.txt");
            dataSaver.saveData(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
