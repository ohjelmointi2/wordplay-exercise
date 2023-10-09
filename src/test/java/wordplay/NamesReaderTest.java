package wordplay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class NamesReaderTest {

    @Test
    void testNamesReaderImplementsReaderInterface() {
        var reader = new NamesReader();

        assertTrue(reader instanceof Reader, "NamesReader should implement Reader interface");
    }

    @Test
    void testReadingNamesFromCsvFile() throws Exception {
        var namesReader = getReader();

        var names = namesReader.readFile(Path.of("data", "etunimitilasto-naiset-ensimmainen.csv"));

        assertNotNull(names);
        assertFalse(names.isEmpty(), "List of read names cannot be empty");

        var first = names.get(0);
        assertEquals("Anne", first, "First name in the file should be Anne");

        var last = names.get(names.size() - 1);
        assertEquals("Åsa-Maria", last, "Last name in the file should be Åsa-Maria");
    }

    /**
     * Helper method to get a Reader instance. This is needed because in the
     * exercise template NamesReader class does not implement the Reader interface.
     *
     * @return
     */
    private Reader getReader() {
        var reader = new NamesReader();
        if (reader instanceof Reader) {
            return (Reader) reader;
        }
        throw new RuntimeException("NamesReader does not implement Reader interface");
    }
}
