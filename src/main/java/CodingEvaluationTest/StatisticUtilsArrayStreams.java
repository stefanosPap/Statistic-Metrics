package CodingEvaluationTest;

import org.openjdk.jmh.annotations.*;

import java.util.*;

/**
 * Statistical metrics for an array of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayStreams {

    /**
     * Calculates array's minimum value
     * @return minimum value
     */
    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public double getMinimum(BenchmarkRunner.StateObj state){
        return Arrays.stream(state.array).min().orElse(Double.NEGATIVE_INFINITY);
    }

    /**
     * Calculates array's maximum value
     * @return maximum value
     */
    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public double getMaximum(BenchmarkRunner.StateObj state){
        return Arrays.stream(state.array).max().orElse(Double.NEGATIVE_INFINITY);    }

    /**
     * Calculates array's median
     * @return median value
     */
    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public double getMedian(BenchmarkRunner.StateObj state){
        return Arrays.stream(state.array)
                     .sorted()
                     .skip(Math.round(state.array.length / 2D - 1))
                     .limit(1 + (1 + state.array.length) % 2)
                     .average()
                     .orElse(Double.NEGATIVE_INFINITY);
    }

    /**
     * Calculates array's mean
     * @return mean value
     */
    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public double getMean(BenchmarkRunner.StateObj state){
        return Arrays.stream(state.array).average().orElse(Double.NEGATIVE_INFINITY);    }

    /**
     * Calculates array's standard deviation
     * @return standard deviation
     */
    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public double getStandardDeviation(BenchmarkRunner.StateObj state){
        return Arrays.stream(state.array).map(i -> i - getMean(state))
                     .map(i -> Math.pow(i, 2))
                     .average()
                     .stream()
                     .map(Math::sqrt)
                     .sum();
    }

}
