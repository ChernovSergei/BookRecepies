import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReceiptToJSON {

    public static String convertRecepieIntoStringJSON (Recepie recepie) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(recepie);
    }
}
