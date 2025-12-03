package wordplay.benchmark;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import wordplay.io.DictionaryReader;

public class ReverseWordPairs {

    private static List<String> words = DictionaryReader.readFinnishWords();

    public static void main(String[] args) {
        getReverseWordPairs(words)
                .stream()
                .forEach(System.out::println);
    }

    public static List<String> getReverseWordPairs(List<String> words) {
        List<String> found = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(words);

        // n words
        for (String w : words) {

            String reversed = reverse(w);

            // O(1) average time complexity
            if (wordSet.contains(reversed)) {
                found.add(w);
            }
        }
        return found;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
