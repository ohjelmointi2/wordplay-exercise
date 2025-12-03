package wordplay.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import wordplay.benchmark.ReverseWordPairs;

public class ReverseWordPairsTest {

    @Test
    public void reverseWordPairsAreReturnedCorrectly() {
        List<String> words = List.of("sula", "äksy", "java", "alus", "yskä", "python");

        List<String> result = ReverseWordPairs.getReverseWordPairs(words);

        assertItemsMatch(result, "sula", "alus", "äksy", "yskä");
    }

    private static void assertItemsMatch(Collection<String> actual, String... expected) {
        assertEquals(expected.length, actual.size());
        assertTrue(actual.containsAll(List.of(expected)));
    }
}
