import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;

/**
 * Statistical metrics for an array of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArray {

    private double[] array;
    /**
     * Default Constructor
     */
    public StatisticUtilsArray(){
    }

    /**
     * Constructor
     * @param array values provided for metrics calculation
     */
    public StatisticUtilsArray(double[] array){
        this.array = array;
    }

    /**
     * Calculates array's minimum value
     * @param array array to calculate minimum value
     * @return minimum value
     */
    public double getMinimum(double[] array){
        Min m = new Min();
        double minimum = m.evaluate(array);
        return minimum;
    }

    /**
     * Calculates array's maximum value
     * @param array array to calculate maximum value
     * @return maximum value
     */
    public double getMaximum(double[] array){
        Max m = new Max();
        double maximum = m.evaluate(array);
        return maximum;
    }

    /**
     * Calculates array's median
     * @param array array to calculate median
     * @return median value
     */
    public double getMedian(double[] array){
        Median m = new Median();
        double median = m.evaluate(array);
        return median;
    }

    /**
     * Calculates array's mean
     * @param array array to calculate mean
     * @return mean value
     */
    public double getMean(double[] array){
        Mean m = new Mean();
        double mean = m.evaluate(array);
        return mean;
    }

    /**
     * Calculates array's standard deviation
     * @param array array to calculate standard deviation
     * @return standard deviation
     */
    public double getStandardDeviation(double[] array){
        StandardDeviation m = new StandardDeviation();
        double std = m.evaluate(array);     // sample standard deviation
                                            // divided by n - 1
        return std;
    }

    /**
     * Calculates array's total metrics
     * @param array array to calculate metrics
     * @return metrics
     */
    public double[] getStats(double[] array){
        double minimum = this.getMinimum(array);
        double maximum = this.getMaximum(array);
        double median = this.getMedian(array);
        double mean = this.getMean(array);
        double std = this.getStandardDeviation(array);
        double[] stats = {minimum, maximum, median, mean, std};
        return stats;
    }

    /**
     * Tests array metrics that provided by StatisticUtilsArray
     * @param args command-line arguments
     */
    public static void main(String[] args){
        double[] array = {1.0,2.0,3.0,4.0,5.0,6.0};
        StatisticUtilsArray stats = new StatisticUtilsArray(array);

        double minimum = stats.getMinimum(array);
        double maximum = stats.getMaximum(array);
        double median = stats.getMedian(array);
        double mean = stats.getMean(array);
        double std = stats.getStandardDeviation(array);

        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Median value: " + median);
        System.out.println("Mean value: " + mean);
        System.out.println("Standard deviation value: " + std);

    }
}
