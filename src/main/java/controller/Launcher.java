package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
    //TODO: Refactor file storage behaviour - application should upload/ download all recipes instead of
    //      upload/ download each recipe separately. All recipes will be saved in hashmap. Then work with this hashmap
    //TODO: Create entity above all recipes - e.g. recipe book
    //TODO: Add Auto Tests for Recipes creation.
    //TODO: Separate client and server locally. There should be two separate apps (console and server)
    //TODO: Create html client
    //TODO: To clients should work in parallel (consider concurrency for CRUD operations)
    //TODO: Fix try catch inside service.ReceiptsJSONFileStorage, methods must throw exceptions
    //TODO: Find good book about Refactoring from Ivan
    //TODO: Question - is it good practice to combine all classes service.Action/service.Tool/service.Product into one package
    //TODO: check short cuts for Intelijj to move methods inside the class. How combine them with VIM shortcuts
    //TODO: Time estimation skill - practice required hours estimation to implement modifications
    //THEORY
    //API - application programmable interface. In this case, these two methods to getRecepies and saveRecepie
    //Low responsibilities shouldn't be located at upper level
    //High responsibilities shouldn't be located at lower level
    //Try to keep hierarhy from upper to lower
    //DI container
    //RESTfull API - ???
    //Learn throw new RuntimeException
    //Rest - interconnection protocol above http

@SpringBootApplication(scanBasePackages = {"service", "controller"})
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
