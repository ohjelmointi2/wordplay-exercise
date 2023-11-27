package wordplay.benchmark;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

import wordplay.io.DictionaryReader;

/**
 * An ArrayList is a List implementation that is based on an array. It is a
 * good choice when you need to access elements by their index, as the
 * elements are stored in a contiguous memory location. Therefore accessing
 * an element by its index is a very fast operation.
 *
 * It is not a good choice when you need to add or remove elements from the
 * middle of the list, as adding or removing elements from the middle of the
 * list requires moving all the elements after the added or removed element.
 * This is a very slow operation.
 *
 * Unlike LinkedLists, the time complexity of accessing an element by its index
 * is O(1) for an ArrayList. This means that the time it takes to access an
 * element does not depend on the size of the list.
 *
 * This class uses the Java Microbenchmark Harness (JMH) to measure the
 * time it takes to perform certain operations on an ArrayList.
 */
public class ArrayListBenchmark extends BenchmarkConfig {

    // We use the list of all Finnish words as our data set.
    private static final List<String> finnishWords = DictionaryReader.readFinnishWords();

    // This is the list we will use in our benchmarks.
    private static final ArrayList<String> arrayList = new ArrayList<>(finnishWords);

    @Benchmark
    public void accessArrayListWithIndex() {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).length(); // just any operation
        }
    }

    @Benchmark
    public void accessArrayListWithIterator() {
        for (String word : arrayList) {
            word.length(); // the same operation as above, for comparison
        }
    }

    @Benchmark
    public void addStringsToBeginningOfArrayList() {
        List<String> newList = new ArrayList<>();

        for (String word : finnishWords) {
            newList.add(0, word);
        }
    }
}
