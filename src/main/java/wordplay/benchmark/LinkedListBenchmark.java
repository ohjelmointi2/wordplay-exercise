package wordplay.benchmark;

import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

import wordplay.io.DictionaryReader;

/**
 * A LinkedList is a List where each element is linked to the next element.
 * This means that accessing an element by its index is a slow operation,
 * as we need to traverse the list from the beginning to the element we
 * want to access.
 *
 * This class contains methods that iterate over the same list using
 * different approaches. The first method uses the index of the element
 * to access it. The second method uses an iterator to iterate over the
 * list. There should be a significant difference in the time it takes
 * to iterate over the list using these two approaches.
 *
 * This class uses the Java Microbenchmark Harness (JMH) to measure the
 * time it takes to perform certain operations on a LinkedList.
 */
public class LinkedListBenchmark extends BenchmarkConfig {

    // We use the list of all Finnish words as our data set.
    private static final List<String> finnishWords = DictionaryReader.readFinnishWords();

    // This is the list we will use in our benchmarks.
    private static final LinkedList<String> linkedList = new LinkedList<>(finnishWords);

    @Benchmark
    public void accessLinkedListWithIndex() {
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i).length(); // just any operation
        }
    }

    @Benchmark
    public void accessLinkedListWithIterator() {
        for (String word : linkedList) {
            word.length(); // the same operation as above, for comparison
        }
    }

    @Benchmark
    public void addStringsToBeginningOfLinkedList() {
        List<String> newList = new LinkedList<>();

        for (String word : finnishWords) {
            newList.add(0, word);
        }
    }
}
