package wordplay;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DictionaryReader {

    /**
     * Reads the given text file and returns a new list, where each line of the
     * file is its own string.
     *
     * @param file for example "kaikkisanat.txt"
     * @return words in that file: ["aakkonen", "aakkosellinen", "aakkosellisesti"]
     */
    public List<String> readWords(String file) {

        try {
            Path path = Paths.get("data", file);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            return lines;

        } catch (IOException e) {
            // Instead of having to deal with checked IOExceptions in the calling side,
            // potential exceptions are wrapped in unchecked RuntimeExceptions. Read more at
            // https://www.baeldung.com/java-wrapping-vs-rethrowing-exceptions#throw-different-exception.
            throw new RuntimeException(e);
        }
    }
}
