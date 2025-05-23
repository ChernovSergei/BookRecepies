import org.junit.Assert;
import org.junit.Test;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class JSONRecipeConverterTest {

    @Test
    public void whenExpectedEqualsToActualRecepie() {
        String recepieName = "Borsch";
        String productName = "Beet root";
        String productType = "Vegetable";
        String toolName = "Knife";
        String actionName = "Cut";
        Recipe expectedRecepie = new Recipe(recepieName);
        Product beetRoot = new Product(productName, productType);
        Tool knife = new Tool(toolName);
        Action cut = new Action(actionName);
        List<RecipeStep> recipeSteps = new ArrayList<>();
        RecipeStep recipeStep = new RecipeStep(beetRoot, knife, cut);
        recipeSteps.add(recipeStep);
        expectedRecepie.setSteps(recipeSteps);
        String recepieInJSON = "{\"name\":\"Borsch\",\"steps\":[{\"product\":{\"name\":\"Beet root\",\"type\":\"Vegetable\"},\"tool\":{\"name\":\"Knife\"},\"action\":{\"name\":\"Cut\"}}]}";
        Recipe result = JSONRecipeConverter.jsonToRecepie(recepieInJSON);
        Assert.assertEquals(expectedRecepie, result);
    }
}