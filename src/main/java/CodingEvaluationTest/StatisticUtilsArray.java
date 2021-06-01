package CodingEvaluationTest;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.openjdk.jmh.annotations.*;

/**
 * Statistical metrics for an array of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {

    /**
     * Default Constructor
     */
    public StatisticUtilsArray(){
    }

    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public static double getMinimum(BenchmarkRunner.StateObj state){
        Min m = new Min();
        return m.evaluate(state.array);
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
    public static double getMaximum(BenchmarkRunner.StateObj state){
        Max m = new Max();
        return m.evaluate(state.array);
    }

    /**
     * Calculates array's median
     * @return median value
     */

    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public static double getMedian(BenchmarkRunner.StateObj state){
        Median m = new Median();
        return m.evaluate(state.array);
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
    public static double getMean(BenchmarkRunner.StateObj state){
        Mean m = new Mean();
        return m.evaluate(state.array);
    }

    /**
     * Calculates array's standard deviation
     * @return standard deviation
     */

    @Benchmark
    @Fork(value=1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public static double getStandardDeviation(BenchmarkRunner.StateObj state){
        StandardDeviation m = new StandardDeviation();
        return m.evaluate(state.array);   // sample standard deviation
                                    // divided by n - 1
    }
}

