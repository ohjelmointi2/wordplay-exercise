package wordplay.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class reads text files and returns a list of words from the file.
 * The file is assumed to be in UTF-8 encoding and to only contain words,
 * one word per line.
 */
public class DictionaryReader implements WordplayReader {

    /**
     * An utility method to read all Finnish words from the file.
     * 
     * @return a list of all Finnish words
     */
    public static List<String> readFinnishWords() {
        WordplayReader reader = new DictionaryReader();
        return reader.readFile(Path.of("data", "kaikkisanat.txt"));
    }

    @Override
    public List<String> readFile(Path file) {
        try {
            // As the file contains just the words and nothing else,
            // we do not need to skip any lines or do any other processing.
            return Files.readAllLines(file, StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
