package wordplay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class NamesReaderTest {

    @Test
    void testReadingNamesFromCsvFile() throws Exception {
        var reader = new NamesReader();

        var names = reader.readNames("etunimitilasto-naiset-ensimmainen.csv");
        assertFalse(names.isEmpty(), "List of read names cannot be empty");

        var first = names.get(0);
        assertEquals("Anne", first, "First name in the file should be Anne");

        var last = names.get(names.size() - 1);
        assertEquals("Åsa-Maria", last, "Last name in the file should be Åsa-Maria");
    }
}
