package wordplay.io;

import java.nio.file.Path;
import java.util.List;

/**
 * This interface defines the method for reading files in this exercise. The
 * `readFile` method should read the given file and return a list of strings,
 * where the contents of the strings depend on the implementation.
 *
 * For example, the `DictionaryReader` assumes that the file contains one word
 * per line, while the `NamesReader` assumes that the file contains rows of data
 * separated by semicolons. The `readFile` method should return the data in a
 * format that is easy to use in the application.
 */
public interface WordplayReader {

    List<String> readFile(Path file);
}
