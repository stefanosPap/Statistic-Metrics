package CaliperProject;

import com.google.caliper.SimpleBenchmark;

import java.util.Arrays;

/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayStreams extends SimpleBenchmark {

    double[] array = {1.0, 2.0};

    /**
     * Calculates array's minimum value
     *
     * @return minimum value
     */
    public double timeGetMinimumStreams(int reps) {

        double min = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < reps; i++) {
            min = Arrays.stream(array).min().orElse(Double.NEGATIVE_INFINITY);
        }
        return min;
    }

    /**
     * Calculates array's maximum value
     *
     * @return maximum value
     */
    public double timeGetMaximumStreams(int reps) {

        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < reps; i++) {
            max = Arrays.stream(array).max().orElse(Double.NEGATIVE_INFINITY);
        }
        return max;
    }

    /**
     * Calculates array's median
     *
     * @return median value
     */
    public double timeGetMedianStreams(int reps) {

        double median = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < reps; i++) {

            median = Arrays.stream(array)
                           .sorted()
                           .skip(Math.round(array.length / 2D - 1))
                           .limit(1 + (1 + array.length) % 2)
                           .average()
                           .orElse(Double.NEGATIVE_INFINITY);
        }
        return median;
    }

    /**
     * Calculates array's mean
     *
     * @return mean value
     */
    public double timeGetMeanStreams(int reps) {

        double mean = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < reps; i++) {

            mean = Arrays.stream(array).average().orElse(Double.NEGATIVE_INFINITY);
        }
        return mean;
    }

    /**
     * Calculates array's standard deviation
     *
     * @return standard deviation
     */
    public double timeGetStandardDeviationStreams(int reps) {

        double std = Double.NEGATIVE_INFINITY;

        for (int j = 0; j < reps; j++) {

            std = Arrays.stream(array).map(i -> i - timeGetMeanStreams(reps))
                        .map(i -> Math.pow(i, 2))
                        .average()
                        .stream()
                        .map(Math::sqrt)
                        .sum();
        }
        return std;
    }

}
