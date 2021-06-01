package CaliperProject;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;

/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray extends SimpleBenchmark {

    double[] array = {1.0, 2.0};

    public double timeGetMinimum(int reps) {

        Min m = new Min();
        for (int i = 0; i < reps; i++) {
                m.evaluate(array);

        }
        return m.evaluate(array);
    }

    public double timeGetMaximum(int reps) {

        Max m = new Max();
        for (int i = 0; i < reps; i++) {
                m.evaluate(array);

        }
        return m.evaluate(array);
    }

    public double timeGetMean(int reps) {

        Mean m = new Mean();
        for (int i = 0; i < reps; i++) {
                m.evaluate(array);

        }
        return m.evaluate(array);
    }

    public double timeGetMedian(int reps) {

        Median m = new Median();
        for (int i = 0; i < reps; i++) {
                m.evaluate(array);

        }
        return m.evaluate(array);
    }

    public double timeGetStd(int reps) {

        StandardDeviation m = new StandardDeviation();
        for (int i = 0; i < reps; i++) {
                m.evaluate(array);

        }
        return m.evaluate(array);
    }

    public static void main(String[] args) {

        Runner.main(StatisticUtilsArray.class, new String[0]);
    }
}


