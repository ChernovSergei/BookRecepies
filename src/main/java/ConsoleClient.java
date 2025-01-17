public class ConsoleClient {

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

    public void saveRecepieToFile() {
        assignStorageFileNameAndDirectory();
        controller.trySaveRecepie(recepiesStorageFileDirrectory, recepiesStorageFileName);
    }

    public void printAllRecepies() {
        controller.getAllRecepies(recepiesStorageFileDirrectory, recepiesStorageFileName).forEach(System.out::println);
    }

    public void assignStorageFileNameAndDirectory() {
        String areChangesRequired = "Enter 'Yes' if storage name and directory must be Replaced";
        if (recepiesStorageFileDirrectory == null || recepiesStorageFileName == null
                || input.askString(areChangesRequired).equals("Yes")) {
            recepiesStorageFileDirrectory = input.askString("Enter directory to save Recepie");
            recepiesStorageFileName = input.askString("Enter file name to save Recepie");
        }
    }
}