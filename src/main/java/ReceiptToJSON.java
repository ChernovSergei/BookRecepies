import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReceiptToJSON {

    public String convertRecepieIntoStringJSON (Recepie recepie) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recepie);
    }
}
