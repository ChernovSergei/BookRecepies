package service;

import controller.RecepiesService;

public class ConsoleClient {

    private final Input input = new ConsoleInput();
    private RecepiesService service;
    private final RecipeConstructor recipeConstructor = new RecipeConstructor();

    public ConsoleClient(RecepiesService service) {
        this.service = service;
    }

    public void createRecepie() {
        String recepieName = input.askString("Enter the recepie name");
        recipeConstructor.createRecepie(recepieName);
    }

    public void addRecepieStep() {
        String productName = input.askString("Enter the product name");
        String productType = input.askString("Enter the product type");
        String tool = input.askString("Enter the tool name");
        String action = input.askString("Enter the action name");
        recipeConstructor.addRecepieStep(productName, productType, tool, action);
    }

    public void saveRecepie() {
        service.save(recipeConstructor.getRecepie());
    }

    public void printAllRecepies() {
        service.getAllRecepies().forEach(System.out::println);
    }
}