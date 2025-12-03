package wordplay.benchmark;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

import wordplay.io.DictionaryReader;

public class ReverseWordPairsBenchmark extends BenchmarkConfig {
    private static List<String> allWords = DictionaryReader.readFinnishWords().subList(0, 64_000);;

    private static List<String> words_8_000 = allWords.subList(0, 8_000);
    private static List<String> words_16_000 = allWords.subList(0, 16_000);
    private static List<String> words_32_000 = allWords.subList(0, 32_000);
    private static List<String> words_64_000 = allWords.subList(0, 64_000);

    @Benchmark
    public void handle_08_000_words() {
        ReverseWordPairs.getReverseWordPairs(words_8_000);
    }

    @Benchmark
    public void handle_16_000_words() {
        ReverseWordPairs.getReverseWordPairs(words_16_000);
    }

    @Benchmark
    public void handle_32_000_words() {
        ReverseWordPairs.getReverseWordPairs(words_32_000);
    }

    @Benchmark
    public void handle_64_000_words() {
        ReverseWordPairs.getReverseWordPairs(words_64_000);
    }
}
