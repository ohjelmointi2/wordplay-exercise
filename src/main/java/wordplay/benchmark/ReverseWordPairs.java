package wordplay.benchmark;

import java.util.ArrayList;
import java.util.List;

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
        words = words.stream().sorted().toList();

        // n words
        for (String w : words) {

            // log(n) lookups
            if (binarySearch(words, reverse(w))) {
                found.add(w);
            }
        }
        return found;
    }

    /**
     * Binary search implementation for a sorted list of strings.
     */
    private static boolean binarySearch(List<String> list, String str) {
        int left = 0, right = list.size() - 1;

        // The distance between left and right is halved on each iteration.
        // We can only split the list log2(n) times until we reach a single element.
        while (left <= right) {

            // Find the middle index. If the string is not found, we will discard the other
            // half of elements remaining in the search space.
            int middle = (left + right) / 2;

            if (list.get(middle).equals(str)) {
                return true;
            }

            // Decide which half to continue searching in.
            if (list.get(middle).compareTo(str) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
