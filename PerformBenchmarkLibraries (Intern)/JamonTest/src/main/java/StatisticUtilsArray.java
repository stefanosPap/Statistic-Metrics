

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import com.jamonapi.*;

/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {

    public static void getMinimum(double[] array) {
        Monitor mon=MonitorFactory.start("MyMonitor");
        Min m = new Min();
        m.evaluate(array);
        System.out.println(mon.stop());


    }

    public static void main(String[] args) {


        getMinimum(new double[]{1.2, 3.0});


    }
}

