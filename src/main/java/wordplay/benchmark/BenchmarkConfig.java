package wordplay.benchmark;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

/**
 * This class contains the configuration for the benchmarks. The actual
 * classes that contain the benchmark methods extend this class, so that
 * they do not need to repeat the configuration.
 */
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
public class BenchmarkConfig {

}
