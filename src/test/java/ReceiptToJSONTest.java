import junit.framework.Assert;
import org.junit.Test;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class ReceiptToJSONTest {
    @Test
    public void recepieToJSONMethodCheck() {
        String recepieName = "Borsch";
        String productName = "Beet root";
        String productType = "Vegetable";
        String toolName = "Knife";
        String actionName = "Cut";
        Recipe testRecepie = new Recipe(recepieName);
        Product beetRoot = new Product(productName, productType);
        Tool knife = new Tool(toolName);
        Action cut = new Action(actionName);
        List<RecipeStep> recipeSteps = new ArrayList<>();
        RecipeStep recipeStep = new RecipeStep(beetRoot, knife, cut);
        recipeSteps.add(recipeStep);
        testRecepie.setSteps(recipeSteps);
        String result = JSONRecipeConverter.recepieToJson(testRecepie);
        String expectedRecepie = "{\"name\":\"Borsch\",\"steps\":[{\"product\":{\"name\":\"Beet root\",\"type\":\"Vegetable\"},\"tool\":{\"name\":\"Knife\"},\"action\":{\"name\":\"Cut\"}}]}";
        Assert.assertEquals(expectedRecepie, result);
    }
}