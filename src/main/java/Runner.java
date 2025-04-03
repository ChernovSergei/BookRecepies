import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class Runner{
    //TODO: Manage several recepies creation which will be stored in one file.
    // New receipes could be added without overwritting
    //TODO: Add Auto Tests for Receipes creation.
    //TODO: Separate client and server locally. There should be two separate apps (console and server)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan

    //TODO: Question - is it good practice to combine all classes Action/Tool/Product into one package
    public static void main(String[] args) throws IOException{
        StringBuilder responseBuilder = new StringBuilder();
        String storagePath = "path";
        String storageName = "Recepies.txt";
        RecepiesStorage recepiesStorage = new ReceiptsJSONFileStorage(storagePath, storageName);
        List<Recepie> recepies = recepiesStorage.getAll();
        recepies.forEach(responseBuilder::append);
        String response = responseBuilder.toString();
        int port = 80;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/all", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port " + port);
    }
}
