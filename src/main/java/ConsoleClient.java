public class ConsoleClient {

    //TODO refactor Controller methods trySaveRecepie() and getAllRecepies()
    //TODO: Create two branches for above mentioned modifications (1 hr)
    //TODO: Refactor ConsoleClient class (4 hr)
    //TODO: Add file storage to saveRecepie (e.g. JSON) (6 hr)
    //TODO: Time estimation skill - estimate required hours for those modifications
    //TODO: Find good book about Refactoring from Ivan
    //TODO Identify if workspace.xml have to be deleted from GIT monitor
    private final Input input = new ConsoleInput();
    private Controller controller = new Controller();
    private String recepiesStorageFileDirrectory = null;
    private String recepiesStorageFileName = null;

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

    public void assignStorageFileNameAndDirectory() {
        recepiesStorageFileDirrectory = input.askString("Enter directory to save Recepie");
        recepiesStorageFileName = input.askString("Enter file name to save Recepie");
    }
}