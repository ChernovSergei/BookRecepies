import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataSaverToFile implements Saver {
    private final Path directory;
    private final Path fullDirectory;

    public DataSaverToFile(String directory, String file) throws IOException {
        this.directory = Path.of(directory);
        String fullDirectory = directory + file;
        this.fullDirectory = Path.of(fullDirectory);
        if (!Files.exists(this.directory)) {
            Files.createDirectories(this.directory);
        }
        if (!Files.exists(this.fullDirectory)) {
            Files.createFile(this.fullDirectory);
        }
    }

    @Override
    public void saveData(String data) {
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(this.fullDirectory.toFile())))) {
            output.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}