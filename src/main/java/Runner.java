import java.io.IOException;
import java.io.Serializable;

public class Runner {
    //TODO: Manage several recepies creation which will be stored in one file.
    // New receipes could be added without overwritting
    //TODO: Add Auto Tests for Receipes creation.
    //TODO: Separate client and server locally. There should be two separate apps (console and server)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan

    //TODO: Question - is it good practice to combine all classes Action/Tool/Product into one package
    public static void main(String[] args) throws IOException {
        RecepiesStorage recepiesStorage = new ReceiptsJSONFileStorage();
        RecepiesService recepiesService = new Controller(recepiesStorage);
        ConsoleClient input = new ConsoleClient(recepiesService);
        input.createRecepie();
        input.addRecepieStep();
        input.saveRecepie();
        input.createRecepie();
        input.addRecepieStep();
        input.saveRecepie();
        input.printAllRecepies();
    }
}
