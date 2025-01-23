public class RecepieConstructor {
    private Recepie recepie;

    public Recepie getRecepie() {
        return recepie;
    }

    public Recepie createRecepie(String recepieName) {
        recepie = new Recepie(recepieName);
        return recepie;
    }

    public void addRecepieStep(String productName, String productType, String tool, String action) {
        Product userProduct = new Product(productName, productType);
        Tool userTool = new Tool(tool);
        Action userAction = new Action(action);
        RecepieStep recepieStep = new RecepieStep(userProduct, userTool, userAction);
        recepie.getSteps().add(recepieStep);
    }
}
