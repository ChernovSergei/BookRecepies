import org.junit.Assert;
import org.junit.Test;
import service.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RecepiesReaderWriterToFileTests {

    @Test
    public void writeAndReadOneRecepieFromFile() {
        String recepieName = "Borsch";
        String productName = "Beet root";
        String productType = "Vegetable";
        String toolName = "Knife";
        String actionName = "Cut";
        String path = "src/main/resources";
        String fileName = "recepieTest";

        String actualRecepie = "{\"name\":\"" + recepieName + "\",\"steps\":[{" +
                "\"product\":{\"name\":\"" + productName +
                "\",\"type\":\"" + productType + "\"}," +
                "\"tool\":{\"name\":\"" + toolName + "\"}," +
                "\"action\":{\"name\":\"" + actionName + "\"}" +
                "}]" +
                "}";
        List<Recipe> actualRecepieList = null;

        Recipe expectedRecepie = new Recipe(recepieName);
        List<RecipeStep> borschPreparationSteps = new ArrayList<>();
        Product beet = new Product(productName, productType);
        Tool knife = new Tool(toolName);
        Action cut = new Action(actionName);
        RecipeStep cutTheBeet = new RecipeStep(beet, knife, cut);
        borschPreparationSteps.add(cutTheBeet);
        expectedRecepie.setSteps(borschPreparationSteps);
        try {
            Path testStorageFile = Path.of(path + "/" + fileName);
            Files.deleteIfExists(testStorageFile);
            RecipesJSONFileStorage recepiesStorage = new RecipesJSONFileStorage(path, fileName);
            //recepieWriteToFile.saveRecepie(actualRecepie);
            List<Recipe> recepies = new ArrayList<>();
            recepies.add(expectedRecepie);
            recepiesStorage.saveAll(recepies);
            actualRecepieList = recepiesStorage.getAll();
            Files.deleteIfExists(testStorageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1, actualRecepieList.size());
        Assert.assertEquals(expectedRecepie, actualRecepieList.get(0));
    }

    @Test
    public void writeAndReadTwoRecepiesFromFile() {
        String recepieName1 = "Borsch";
        String productName1 = "Beet root";
        String productType1 = "Vegetable";
        String toolName1 = "Knife";
        String actionName1 = "Cut";

        String recepieName2 = "Carbonara";
        String productName2 = "Fetuchini";
        String productType2 = "Pasta";
        String toolName2 = "Pot";
        String actionName2 = "Boil";

        String path = "src/main/resources";
        String fileName = "recepieTest";

        String actualRecepie1 = "{\"name\":\"" + recepieName1 + "\",\"steps\":[{" +
                "\"product\":{\"name\":\"" + productName1 +
                "\",\"type\":\"" + productType1 + "\"}," +
                "\"tool\":{\"name\":\"" + toolName1 + "\"}," +
                "\"action\":{\"name\":\"" + actionName1 + "\"}" +
                "}]" +
                "}";
        String actualRecepie2 = "{\"name\":\"" + recepieName2 + "\",\"steps\":[{" +
                "\"product\":{\"name\":\"" + productName2 +
                "\",\"type\":\"" + productType2 + "\"}," +
                "\"tool\":{\"name\":\"" + toolName2 + "\"}," +
                "\"action\":{\"name\":\"" + actionName2 + "\"}" +
                "}]" +
                "}";
        List<Recipe> actualRecepieList = null;

        Recipe expectedRecepie1 = new Recipe(recepieName1);
        List<RecipeStep> borschPreparationSteps = new ArrayList<>();
        Product beet = new Product(productName1, productType1);
        Tool knife = new Tool(toolName1);
        Action cut = new Action(actionName1);
        RecipeStep cutTheBeet = new RecipeStep(beet, knife, cut);
        borschPreparationSteps.add(cutTheBeet);
        expectedRecepie1.setSteps(borschPreparationSteps);

        Recipe expectedRecepie2 = new Recipe(recepieName2);
        List<RecipeStep> carbonaraPreporationSteps = new ArrayList<>();
        Product fetuchini = new Product(productName2, productType2);
        Tool pot = new Tool(toolName2);
        Action boil = new Action(actionName2);
        RecipeStep boilFetuchini = new RecipeStep(fetuchini, pot, boil);
        carbonaraPreporationSteps.add(boilFetuchini);
        expectedRecepie2.setSteps(carbonaraPreporationSteps);
        try {
            Path testStorageFile = Path.of(path + "/" + fileName);
            Files.deleteIfExists(testStorageFile);
            RecipesJSONFileStorage recepiesStorage = new RecipesJSONFileStorage(path, fileName);
            //recepieWriteToFile.saveRecepie(actualRecepie1);
            //recepieWriteToFile.saveRecepie(actualRecepie2);
            List<Recipe> recepies = new ArrayList<>();
            recepies.add(expectedRecepie1);
            recepies.add(expectedRecepie2);
            recepiesStorage.saveAll(recepies);
            actualRecepieList = recepiesStorage.getAll();
            Files.deleteIfExists(testStorageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, actualRecepieList.size());
        Assert.assertEquals(expectedRecepie1, actualRecepieList.get(0));
        Assert.assertEquals(expectedRecepie2, actualRecepieList.get(1));
    }
}
