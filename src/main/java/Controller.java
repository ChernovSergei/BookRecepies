public class Controller {
    private String recepieFormat = "%s the %s with a %s\n";
    private final RecepieConstructor recepieConstructor;

    public Controller() {
        this.recepieConstructor = new RecepieConstructor();
    }

    public void createReceipe() {
        recepieConstructor.createRecepie(ConsoleClient.requestRecepieName());
    }

    public RecepieStep createRecepieStep() {
        String action = ConsoleClient.requestActionName();
        String tool = ConsoleClient.requestToolName();
        String productType = ConsoleClient.requestProductType();
        String product = ConsoleClient.requestProductName();
        return recepieConstructor.createRecepieStep(product, productType, tool, action);
    }

    public void addRecepieStep(RecepieStep recepieStep) {
        recepieConstructor.addRecepieStep(recepieStep);
    }

    public void saveRecepie() {
        recepieConstructor.getRecepie().getSteps().forEach(e -> {
            String actionName = e.getAction().getName();
            String productName = e.getProduct().getName();
            String toolName = e.getTool().getName();
            System.out.printf(recepieFormat, actionName, productName, toolName);
        });
    }
}
