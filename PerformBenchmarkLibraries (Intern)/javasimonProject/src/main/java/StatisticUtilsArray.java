

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;

/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {

    public static void getMinimum(double[] array) {
            Min m = new Min();
            m.evaluate(array);
    }
    public static void getMaximum(double[] array) {
        Max m = new Max();
        m.evaluate(array);
    }
    public static void main(String[] args) {

        Stopwatch stopwatch = SimonManager.getStopwatch("use.basic");
        Split split = stopwatch.start();
        getMinimum(new double[]{1.2, 3.0});
        getMaximum(new double[]{1.2, 3.0});
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample());
        System.out.println(stopwatch.getCounter());
        System.out.println(stopwatch.getMax()/1000/1000);       //Convert nano-secs to milli-secs
        System.out.println(stopwatch.getMin()/1000/1000);
        System.out.printf("%.2f%n", stopwatch.getMean()/1024/1024);
        System.out.println(stopwatch.getTotal()/1000/1000);

    }
}

