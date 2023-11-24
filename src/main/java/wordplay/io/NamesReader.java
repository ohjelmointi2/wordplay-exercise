package wordplay.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class reads CSV files and returns a list of names from the file.
 *
 * The file is assumed to contain a header row, which is skipped. Each row
 * contains the name and the number of people with that name, separated by a
 * semicolon. For example: "Anne;123" or "Tuula;111".
 *
 * The returned list contains the names in the same order as they appear in the
 * file. The number of people with that name is not included. For example:
 * ["Anne", "Tuula"]
 */
public class NamesReader implements WordplayReader {
    private static Path women = Path.of("data", "etunimitilasto-naiset-ensimmainen.csv");
    private static Path men = Path.of("data", "etunimitilasto-miehet-ensimmainen.csv");

    public static List<String> readFirstNames() {
        NamesReader namesReader = new NamesReader();

        return Stream.concat(
                namesReader.readFile(women).stream(),
                namesReader.readFile(men).stream()).toList();
    }

    @Override
    public List<String> readFile(Path file) {
        try {
            return Files.lines(file, StandardCharsets.UTF_8)
                    .skip(1) // skip the header row
                    .map(this::getNameFromCsv)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The name is the first part of the row, before the semicolon. For example:
     * "Anne;123" -> "Anne"
     *
     * @param csvRow a row from the CSV file
     * @return the name from the row
     */
    private String getNameFromCsv(String csvRow) {
        return csvRow.split(";")[0];
    }
}
