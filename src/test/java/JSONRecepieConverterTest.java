import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONRecepieConverterTest {

    @Test
    public void whenExpectedEqualsToActualRecepie() {
        String recepieName = "Borsch";
        String productName = "Beet root";
        String productType = "Vegetable";
        String toolName = "Knife";
        String actionName = "Cut";
        Recepie expectedRecepie = new Recepie(recepieName);
        Product beetRoot = new Product(productName, productType);
        Tool knife = new Tool(toolName);
        Action cut = new Action(actionName);
        List<RecepieStep> recepieSteps = new ArrayList<>();
        RecepieStep recepieStep = new RecepieStep(beetRoot, knife, cut);
        recepieSteps.add(recepieStep);
        expectedRecepie.setSteps(recepieSteps);
        String recepieInJSON = "{\"name\":\"Borsch\",\"steps\":[{\"product\":{\"name\":\"Beet root\",\"type\":\"Vegetable\"},\"tool\":{\"name\":\"Knife\"},\"action\":{\"name\":\"Cut\"}}]}";
        Recepie result = JSONRecepieConverter.jsonToRecepie(recepieInJSON);
        Assert.assertEquals(expectedRecepie, result);
    }
}