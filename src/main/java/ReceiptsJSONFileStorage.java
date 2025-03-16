import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptsJSONFileStorage implements RecepiesStorage {
    private final Path fullDirectory;

    public ReceiptsJSONFileStorage(String storageDirectory, String storageName) throws IOException {
        //Evil row
        Path directory = Path.of(storageDirectory);
        String fullDirectory = directory + "/" + storageName;
        this.fullDirectory = Path.of(fullDirectory);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        if (!Files.exists(this.fullDirectory)) {
            Files.createFile(this.fullDirectory);
        }
    }

    @Override
    public void save(Recepie recepie) {
        String JSONRecepie = JSONRecepieConverter.recepieToJson(recepie);
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(this.fullDirectory.toFile(), true)))) {
            output.println(JSONRecepie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recepie> getAll() {
        List<Recepie> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Files.readString(this.fullDirectory)).useDelimiter("\n");
            while(scanner.hasNext()) {
                result.add(JSONRecepieConverter.jsonToRecepie(scanner.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}