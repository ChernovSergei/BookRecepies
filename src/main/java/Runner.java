import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.stream.Collectors;

public class Runner{
    //TODO: Add Auto Tests for Receipes creation.
    //TODO: Separate client and server locally. There should be two separate apps (console and server)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    //TODO: Question - is it good practice to combine all classes Action/Tool/Product into one package
    public static void main(String[] args) throws IOException{
        String storagePath = "path";
        String storageName = "Recepies.txt";
        RecepiesStorage recepiesStorage = new ReceiptsJSONFileStorage(storagePath, storageName);
        List<Recepie> recepies = recepiesStorage.getAll();
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        String response = gson.toJson(recepies);
        int port = 80;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/all", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.createContext("/html", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                StringBuilder htmlResponse = new StringBuilder();
                htmlResponse.append("<!DOCTYPE html\n>");
                htmlResponse.append("<html lang=\"en\">\n");
                htmlResponse.append("<head>\n");
                htmlResponse.append("   <meta charset=\"UTF-8\">\n");
                htmlResponse.append("   <meta name=\"viewport\" content=\"width=device-width\">\n");
                htmlResponse.append("   <title>Recipes</title>\n");
                htmlResponse.append("</head>\n");
                htmlResponse.append("<body>\n");
                htmlResponse.append("   <h1>Recipes</h1>\n");
                htmlResponse.append("   <ul>\n");
                for (Recepie recepie : recepies) {
                    htmlResponse.append("       <li>" + recepie.getName() + "</li>\n");
                }
                htmlResponse.append("   </ul>\n");
                htmlResponse.append("</body>\n");
                htmlResponse.append("</html>\n");
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, htmlResponse.toString().length());
                OutputStream os = exchange.getResponseBody();
                os.write(htmlResponse.toString().getBytes());
                os.close();
            }
        });
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port " + port);
    }
}
