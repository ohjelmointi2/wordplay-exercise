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

        for (String w : words) {
            if (words.contains(reverse(w))) {
                found.add(w);
            }
        }
        return found;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
