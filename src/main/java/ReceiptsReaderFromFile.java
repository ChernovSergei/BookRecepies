import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReceiptsReaderFromFile {
    private final Path directory;
    private final Path fullDirectory;

    public ReceiptsReaderFromFile(String directory, String file) throws IOException {
        this.directory = Path.of(directory);
        String fullDirectory = directory + "/" + file;
        this.fullDirectory = Path.of(fullDirectory);
        if (!Files.exists(this.directory)) {
            Files.createDirectories(this.directory);
        }
        if (!Files.exists(this.fullDirectory)) {
            Files.createFile(this.fullDirectory);
        }
    }

    public List<Recepie> returnListOfRecepies() {
        List<Recepie> result = new ArrayList<>();
        try {
            result.add(JSONtoRecepie.convertJSONtoRecepie(Files.readString(this.fullDirectory)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
