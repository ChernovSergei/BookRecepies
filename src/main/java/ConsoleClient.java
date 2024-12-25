import java.util.LinkedList;
import java.util.List;

public class ConsoleClient {

    //TODO: Create two branches for above mentioned modifications (1 hr)
    //TODO: Refactor ConsoleClient class (4 hr)
    //TODO: Add file storage to saveRecepie (e.g. JSON) (6 hr)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    private static final Input input = new ConsoleInput();

    public static void main(String[] args) {
        Recepie recepie = createRecepie();
        Controller controller = new Controller();
        controller.saveRecepie(recepie);
    }

    private static Recepie createRecepie() {
        List<RecepieStep> recepieSteps = createRecepieSteps();
        String recepieName = input.askString("Enter the recepie name");
        Recepie recepie = new Recepie(recepieSteps, recepieName);
        return recepie;
    }

    private static List<RecepieStep> createRecepieSteps() {
        RecepieStep recepieStep = createRecepieStep();
        List<RecepieStep> recepieSteps = new LinkedList<>();
        recepieSteps.add(recepieStep);
        return recepieSteps;
    }

    private static RecepieStep createRecepieStep() {
        String productName = input.askString("Enter the product name");
        String productType = input.askString("Enter the product type name");
        String tool = input.askString("Enter the tool name");
        String action = input.askString("Enter the action name");
        Product userProduct = new Product(productName, productType);
        Tool userTool = new Tool(tool);
        Action userAction = new Action(action);
        RecepieStep recepieStep = new RecepieStep(userProduct, userTool, userAction);
        return recepieStep;
    }
}