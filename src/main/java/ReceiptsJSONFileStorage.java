import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptsJSONFileStorage {
    private final Path fullDirectory;

    public ReceiptsJSONFileStorage() throws IOException {
        //Evil row
        String recepiesStorageFileDirrectory = "path";
        String recepiesStorageFileName = "Recepies.txt";
        Path directory = Path.of(recepiesStorageFileDirrectory);
        String fullDirectory = directory + "/" + recepiesStorageFileName;
        this.fullDirectory = Path.of(fullDirectory);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        if (!Files.exists(this.fullDirectory)) {
            Files.createFile(this.fullDirectory);
        }
    }

    public void saveData(Recepie recepie) {
        String JSONRecepie = ReceiptToJSON.convertRecepieIntoStringJSON(recepie);
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(this.fullDirectory.toFile(), true)))) {
            output.println(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Recepie> returnListOfRecepies() {
        List<Recepie> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Files.readString(this.fullDirectory)).useDelimiter("\n");
            while(scanner.hasNext()) {
                result.add(JSONtoRecepie.convertJSONtoRecepie(scanner.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}