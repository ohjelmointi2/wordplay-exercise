package wordplay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DictionaryReaderTest {

    @Test
    void testReadingDictionaryFromTextFile() throws Exception {
        var reader = new DictionaryReader();

        var words = reader.readWords("kaikkisanat.txt");

        assertEquals(93_086, words.size());

        assertEquals("aakkonen", words.get(0));
        assertEquals("öylätti", words.get(words.size() - 1));
    }
}
