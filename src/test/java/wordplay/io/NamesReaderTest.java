package wordplay.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NamesReaderTest {

    // Path to the file containing the names
    private Path path = Path.of("data", "etunimitilasto-naiset-ensimmainen.csv");

    // Reader instance to use in the tests
    private WordplayReader namesReader = new NamesReader();

    @Test
    void testReadingNamesFromCsvFile() throws Exception {
        List<String> names = namesReader.readFile(path);

        String first = names.get(0);
        assertEquals("Anne", first, "First name in the file should be Anne");

        String last = names.get(names.size() - 1);
        assertEquals("Åsa-Maria", last, "Last name in the file should be Åsa-Maria");
    }

    @Test
    void testReadingBothFemaleAndMaleNamesAtOnce() {
        List<String> finnishNames = NamesReader.readFirstNames();

        assertEquals(15_665, finnishNames.size());
        assertEquals("Anne", finnishNames.get(0));
        assertEquals("Änäs", finnishNames.get(finnishNames.size() - 1));
    }
}
