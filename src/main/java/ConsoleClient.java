import java.util.LinkedList;
import java.util.List;

public class ConsoleClient {
    public static void main(String[] args) {
        Input consoleInput = new ConsoleInput();
        String productName = consoleInput.askString("Enter the product name");
        String productType = consoleInput.askString("Enter the product type name");
        String tool = consoleInput.askString("Enter the tool name");
        String action = consoleInput.askString("Enter the action name");
        Product userProduct = new Product(productName, productType);
        Tool userTool = new Tool(tool);
        Action userAction = new Action(action);
        RecepieStep cutTheMeat = new RecepieStep(userProduct, userTool, userAction);
        List<RecepieStep> boiledMeatSteps = new LinkedList<>();
        boiledMeatSteps.add(cutTheMeat);
        Recepie boiledMeat = new Recepie(boiledMeatSteps, "Boiled Meat");
        Controller controller = new Controller();
        controller.saveRecepie(boiledMeat);
    }
}
