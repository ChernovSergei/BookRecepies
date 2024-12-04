import java.util.LinkedList;
import java.util.List;

public class ConsoleClient {
    public static void main(String[] args) {
        Product meat = new Product("Meat", "Meat");
        Tool knife = new Tool("Knife");
        Action cut = new Action("Cut");
        RecepieStep cutTheMeat = new RecepieStep(meat, knife, cut);
        List<RecepieStep> boiledMeatSteps = new LinkedList<>();
        boiledMeatSteps.add(cutTheMeat);
        Recepie boiledMeat = new Recepie(boiledMeatSteps, "Boiled Meat");
        Controller controller = new Controller();
        controller.saveRecepie(boiledMeat);
    }
}
