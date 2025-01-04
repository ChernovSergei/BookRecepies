public class ConsoleClient {

    //TODO: Create two branches for above mentioned modifications (1 hr)
    //TODO: Refactor ConsoleClient class (4 hr)
    //TODO: Add file storage to saveRecepie (e.g. JSON) (6 hr)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    private static final Input input = new ConsoleInput();

    public static String requestRecepieName() {
        return input.askString("Enter the recepie name");
    }

    public static String requestProductName() {
        return input.askString("Enter the product name");
    }

    public static String requestProductType() {
        return input.askString("Enter the product type");
    }

    public static String requestToolName() {
        return input.askString("Enter the tool name");
    }

    public static String requestActionName() {
        return input.askString("Enter the action name");
    }
}