
import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import etm.core.renderer.SimpleTextRenderer;
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
public class StatisticUtilsArray {
    private static  final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

    public static void getMinimum(double[] array) {

        EtmPoint point = etmMonitor.createPoint("getMinimum");
        try{
            Min m = new Min();
            m.evaluate(array);
        }finally{
            point.collect();
        }

    }

    public static void getMaximum(double[] array) {

        EtmPoint point = etmMonitor.createPoint("getMaximum");
        try{
            Max m = new Max();
            m.evaluate(array);
        }finally{
            point.collect();
        }

    }

    public static void getMean(double[] array) {

        EtmPoint point = etmMonitor.createPoint("getMean");
        try{
            Mean m = new Mean();
            m.evaluate(array);
        }finally{
            point.collect();
        }

    }

    public static void getMedian(double[] array) {

        EtmPoint point = etmMonitor.createPoint("getMedian");
        try{
            Median m = new Median();
            m.evaluate(array);
        }finally{
            point.collect();
        }

    }

    public static void getStd(double[] array) {

        EtmPoint point = etmMonitor.createPoint("getStd");
        try{
            StandardDeviation m = new StandardDeviation();
            m.evaluate(array);
        }finally{
            point.collect();
        }

    }
    public static void main(String[] args) {
        EtmMonitor monitor;
        BasicEtmConfigurator.configure();
        monitor = EtmManager.getEtmMonitor();
        monitor.start();

        getMinimum(new double[]{1.2, 3.0});
        getMaximum(new double[]{1.2, 3.0});
        getMean(new double[]{1.2, 3.0});
        getMedian(new double[]{1.2, 3.0});
        getStd(new double[]{1.2, 3.0});

        etmMonitor.render(new SimpleTextRenderer());

        monitor.stop();

    }
}

