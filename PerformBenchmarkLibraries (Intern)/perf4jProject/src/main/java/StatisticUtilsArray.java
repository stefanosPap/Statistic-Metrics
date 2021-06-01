import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;


/**
 * Statistical metrics for an array of doubles
 *
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {
    private final static Logger logger = Logger.getLogger(StatisticUtilsArray.class);

    public static void getMinimumTest(double[] array) {
            StopWatch stopWatch = new Log4JStopWatch("minimum");
            Min m = new Min();
            m.evaluate(array);
            logger.info("Minimum execution");
            stopWatch.stop();
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Start testing");
        getMinimumTest(new double[]{1.2, 3.0});

    }
}

