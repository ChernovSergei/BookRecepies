import org.junit.Assert;
import org.junit.Test;

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
        List<Recepie> actualRecepieList = null;

        Recepie expectedRecepie = new Recepie(recepieName);
        List<RecepieStep> borschPreparationSteps = new ArrayList<>();
        Product beet = new Product(productName, productType);
        Tool knife = new Tool(toolName);
        Action cut = new Action(actionName);
        RecepieStep cutTheBeet = new RecepieStep(beet, knife, cut);
        borschPreparationSteps.add(cutTheBeet);
        expectedRecepie.setSteps(borschPreparationSteps);
        try {
            Path testStorageFile = Path.of(path + "/" + fileName);
            Files.deleteIfExists(testStorageFile);
            DataSaverToFile recepieWriteToFile = new DataSaverToFile(path, fileName);
            ReceiptsReaderFromFile recepieFromFile = new ReceiptsReaderFromFile(path, fileName);
            recepieWriteToFile.saveData(actualRecepie);
            actualRecepieList = recepieFromFile.returnListOfRecepies();
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
        List<Recepie> actualRecepieList = null;

        Recepie expectedRecepie1 = new Recepie(recepieName1);
        List<RecepieStep> borschPreparationSteps = new ArrayList<>();
        Product beet = new Product(productName1, productType1);
        Tool knife = new Tool(toolName1);
        Action cut = new Action(actionName1);
        RecepieStep cutTheBeet = new RecepieStep(beet, knife, cut);
        borschPreparationSteps.add(cutTheBeet);
        expectedRecepie1.setSteps(borschPreparationSteps);

        Recepie expectedRecepie2 = new Recepie(recepieName2);
        List<RecepieStep> carbonaraPreporationSteps = new ArrayList<>();
        Product fetuchini = new Product(productName2, productType2);
        Tool pot = new Tool(toolName2);
        Action boil = new Action(actionName2);
        RecepieStep boilFetuchini = new RecepieStep(fetuchini, pot, boil);
        carbonaraPreporationSteps.add(boilFetuchini);
        expectedRecepie2.setSteps(carbonaraPreporationSteps);
        try {
            Path testStorageFile = Path.of(path + "/" + fileName);
            Files.deleteIfExists(testStorageFile);
            DataSaverToFile recepieWriteToFile = new DataSaverToFile(path, fileName);
            ReceiptsReaderFromFile recepieFromFile = new ReceiptsReaderFromFile(path, fileName);
            recepieWriteToFile.saveData(actualRecepie1);
            recepieWriteToFile.saveData(actualRecepie2);
            actualRecepieList = recepieFromFile.returnListOfRecepies();
            Files.deleteIfExists(testStorageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, actualRecepieList.size());
        Assert.assertEquals(expectedRecepie1, actualRecepieList.get(0));
        Assert.assertEquals(expectedRecepie2, actualRecepieList.get(1));
    }
}
