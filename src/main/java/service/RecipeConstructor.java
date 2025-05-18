package service;

public class RecipeConstructor {
    private Recipe recepie;

    public Recipe getRecepie() {
        return recepie;
    }

    public Recipe createRecepie(String recepieName) {
        recepie = new Recipe(recepieName);
        return recepie;
    }

    public void addRecepieStep(String productName, String productType, String tool, String action) {
        Product userProduct = new Product(productName, productType);
        Tool userTool = new Tool(tool);
        Action userAction = new Action(action);
        RecipeStep recipeStep = new RecipeStep(userProduct, userTool, userAction);
        recepie.getSteps().add(recipeStep);
    }
}
