package wordplay.benchmark;

import java.io.IOException;

public class BenchmarkRunner {

    /**
     * See the Java Microbenchmark Harness (JMH) documentation:
     * https://github.com/openjdk/jmh
     *
     * Also, see the Baeldung article:
     * https://www.baeldung.com/java-microbenchmark-harness
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
