package wordplay.benchmark;

import java.io.IOException;

public class BenchmarkRunner {

    /**
     * Run this class to run the benchmarks. JMH will scan the project for
     * classes annotated with @Benchmark and run them. The results will be
     * printed to the console.
     *
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
