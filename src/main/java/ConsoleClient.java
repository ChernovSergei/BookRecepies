public class ConsoleClient {

    //TODO: Create two branches for above mentioned modifications (1 hr)
    //TODO: Refactor ConsoleClient class (4 hr)
    //TODO: Add file storage to saveRecepie (e.g. JSON) (6 hr)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    private final Input input = new ConsoleInput();
    private Controller controller = new Controller();

    public void createRecepie() {
        String recepieName = input.askString("Enter the recepie name");
        controller.createReceipe(recepieName);
    }

    public void addRecepieStep() {
        String productName = input.askString("Enter the product name");
        String productType = input.askString("Enter the product type");
        String tool = input.askString("Enter the tool name");
        String action = input.askString("Enter the action name");
        controller.addRecepieStep(productName, productType, tool, action);
    }

    public void saveRecepie() {
        String savePath = input.askString("Enter directory to save Recepie");
        String fileName = input.askString("Enter file name to save Recepie");
    }

    public void getAllRecepies() {

    }
}