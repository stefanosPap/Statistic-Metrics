import java.util.*;
import java.util.stream.DoubleStream;

/**
 * Statistical metrics for an array of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayStreams {

    private DoubleStream stream;
    /**
     * Default Constructor
     */
    public StatisticUtilsArrayStreams(){
    }

    /**
     * Convert array of doubles to stream
     * @param array array to be converted to stream
     */
    public void convertArrayToStream(double[] array){this.stream = Arrays.stream(array);}

    /**
     * Calculates array's minimum value
     * @param array array to calculate minimum value
     * @return minimum value
     */
    public double getMinimum(double[] array){
        this.convertArrayToStream(array);
        return this.stream.min().getAsDouble();
    }

    /**
     * Calculates array's maximum value
     * @param array array to calculate maximum value
     * @return maximum value
     */
    public double getMaximum(double[] array){
        this.convertArrayToStream(array);
        return this.stream.max().getAsDouble();
    }

    /**
     * Calculates array's median
     * @param array array to calculate median
     * @return median value
     */
    public double getMedian(double[] array){
        double median;
        this.convertArrayToStream(array);
        // case of odd
        if (array.length % 2 == 1) {
            median = this.stream.sorted().skip((array.length - 1) / 2).limit(1).min().getAsDouble();    // min() has not specific operation.
                                                                                                        // It is used only to convert the result from DoubleStream to double
        }
        // case of even
        else{
            median = this.stream.sorted().skip((array.length) / 2 - 1).limit(2).average().getAsDouble();
        }
        return median;
    }

    /**
     * Calculates array's mean
     * @param array array to calculate mean
     * @return mean value
     */
    public double getMean(double[] array){
        this.convertArrayToStream(array);
        return this.stream.average().getAsDouble();
    }

    /**
     * Calculates array's standard deviation
     * @param array array to calculate standard deviation
     * @return standard deviation
     */
    public double getStandardDeviation(double[] array){
        double mean = this.getMean(array);
        this.convertArrayToStream(array);
        double std = this.stream.map(i -> i - mean).map(i -> Math.pow(i,2)).average().getAsDouble();    // population standard deviation
                                                                                                        // divided by n
        return Math.sqrt(std);
    }


    /**
     * Tests array metrics that provided by StatisticUtilsArrayStreams
     * @param args command-line arguments
     */
    public static void main(String[] args){
        double[] array = {1.0,2.0,3.0,4.0,5.0,6.0};
        StatisticUtilsArrayStreams stats = new StatisticUtilsArrayStreams();

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
