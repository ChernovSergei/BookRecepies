import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONtoRecepie {
    public static Recepie convertJSONtoRecepie(String recepieInJSON) {
        Gson gsonResult = new GsonBuilder().create();
        return gsonResult.fromJson(recepieInJSON, Recepie.class);
    }
}
