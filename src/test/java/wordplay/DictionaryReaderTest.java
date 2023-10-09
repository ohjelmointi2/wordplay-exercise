package wordplay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class DictionaryReaderTest {

    @Test
    void testDictionaryReaderImplementsReaderInterface() {
        var reader = new DictionaryReader();

        assertTrue(reader instanceof Reader, "DictionaryReader should implement Reader interface");
    }

    @Test
    void testReadingDictionaryFromTextFile() throws Exception {
        var reader = getReader();

        var path = Path.of("data", "kaikkisanat.txt");
        var words = reader.readFile(path);

        assertEquals(93_086, words.size());

        assertEquals("aakkonen", words.get(0));
        assertEquals("öylätti", words.get(words.size() - 1));
    }

    /**
     * Helper method to get a Reader instance. This is needed because in the
     * exercise template NamesReader class does not implement the Reader interface.
     *
     * @return
     */
    private Reader getReader() {
        var reader = new DictionaryReader();
        if (reader instanceof Reader) {
            return (Reader) reader;
        }
        throw new RuntimeException("DictionaryReader does not implement Reader interface");
    }
}
