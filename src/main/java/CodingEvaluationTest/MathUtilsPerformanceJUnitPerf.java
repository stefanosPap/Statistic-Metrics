package analytics.testing.PerformanceTest.MathUtils;

import analytics.testing.CodingEvaluation.StatisticUtilsArray;
import analytics.testing.CodingEvaluation.StatisticUtilsArrayStreams;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.ConsoleReportGenerator;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

public class MathUtilsPerformanceJUnitPerf {
    private static final double[] array = new double[1_000_000];

    static {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextDouble();
        }
    }

    @Rule
    public JUnitPerfRule jUnitPerfRule = new JUnitPerfRule(new ConsoleReportGenerator());

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMinimumTest() {
        StatisticUtilsArray.getMinimum(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMinimumStreamsTest() {
        StatisticUtilsArrayStreams.getMinimum(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMaximumTest() {
        StatisticUtilsArray.getMaximum(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMaximumStreamsTest() {
        StatisticUtilsArrayStreams.getMaximum(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMeanTest() {
        StatisticUtilsArray.getMean(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMeanStreamsTest() {
        StatisticUtilsArrayStreams.getMean(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMedianTest() {
        StatisticUtilsArray.getMedian(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getMedianStreamsTest() {
        StatisticUtilsArrayStreams.getMedian(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getStdTest() {
        StatisticUtilsArray.getStandardDeviation(array);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void getStdStreamsTest() {
        StatisticUtilsArrayStreams.getStandardDeviation(array);
    }
}
