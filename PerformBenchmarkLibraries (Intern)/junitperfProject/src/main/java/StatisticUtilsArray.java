

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.junit.jupiter.api.Test;
import org.junit.Rule;
import org.testng.annotations.Test;
/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {

    @Test
    @JUnitPerfTest(threads = 50, durationMs = 125_000, rampUpPeriodMs = 2_000, warmUpMs = 10_000, maxExecutionsPerSecond = 11_000)
    public static void getMinimumTest(double[] array) {
            Min m = new Min();
            m.evaluate(array);
    }
    public static void getMaximum(double[] array) {
        Max m = new Max();
        m.evaluate(array);
    }
    public static void main(String[] args) {

        getMinimumTest(new double[]{1.2, 3.0});

    }
}

