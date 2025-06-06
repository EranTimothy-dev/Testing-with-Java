package junittesting.tempdirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileProcessor {

    public void convertFilesToUpperCase(Path inputDir, Path outputDir) throws IOException {
        if (!Files.isDirectory(inputDir)) {
            throw new IllegalArgumentException("Input directory does not exist");
        }
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }

        try (Stream<Path> files = Files.list(inputDir)) {
            files.filter(Files::isRegularFile).forEach(file -> {
                try {
                    String content = Files.readString(file);
                    String processedContent = content.toUpperCase();
                    Path outputFile = outputDir.resolve(file.getFileName());
                    Files.writeString(outputFile, processedContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
