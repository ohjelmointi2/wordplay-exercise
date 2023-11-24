package wordplay.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DictionaryReaderTest {

    // Path to the file containing all Finnish words
    Path path = Path.of("data", "kaikkisanat.txt");

    // Reader instance to use in the tests
    private WordplayReader reader = new DictionaryReader();

    @Test
    void testReadingDictionaryFromTextFile() throws Exception {
        List<String> words = reader.readFile(path);

        assertEquals(93_086, words.size());

        assertEquals("aakkonen", words.get(0));
        assertEquals("öylätti", words.get(words.size() - 1));
    }

    @Test
    void testGettingFinnishWordsWithStaticMethod() {
        List<String> finnishWords = DictionaryReader.readFinnishWords();

        assertEquals(93_086, finnishWords.size());
    }
}
