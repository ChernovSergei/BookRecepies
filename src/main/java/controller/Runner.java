package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Recepie;

import java.io.IOException;
import java.util.List;

public class Runner{
    //TODO: Add Auto Tests for Receipes creation.
    //TODO: Separate client and server locally. There should be two separate apps (console and server)
    //TODO: Fix try catch inside service.ReceiptsJSONFileStorage, methods must throw exceptions
    //TODO: Find good book about Refactoring from Ivan
    //TODO: Question - is it good practice to combine all classes service.Action/service.Tool/service.Product into one package
    //TODO: Learn throw new RuntimeException
    //TODO: check short cuts for Intelijj to move methods inside the class. How combine them with VIM shortcuts
    //TODO: RESTfull API - ???
    //TODO: Time estimation skill - practice required hours estimation to implement modifications
    //Theory
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    //Low responsibilities shouldn't be located at upper level
    //High responsibilities shouldn't be located at lower level
    //Try to keep hierarhy from upper to lower
    //DI container

    public String run() throws IOException{
        StringBuilder result = new StringBuilder();
        String storagePath = "path";
        String storageName = "Recepies.txt";
        service.RecepiesStorage recepiesStorage = new service.ReceiptsJSONFileStorage(storagePath, storageName);
        List<Recepie> recepies = recepiesStorage.getAll();
        recepies.forEach(result::append);
        return result.toString();
/*        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
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
                for (service.Recepie recepie : recepies) {
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
        System.out.println("Server started on port " + port);*/
    }
}
