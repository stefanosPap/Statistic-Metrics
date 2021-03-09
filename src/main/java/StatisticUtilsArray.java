import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;

public class StatisticUtilsArray {
    private double[] array;

    public StatisticUtilsArray(){
    }

    public StatisticUtilsArray(double[] array){
        this.setArray(array);

    }

    public void setArray(double[] array){
        this.array = array;
    }

    public double getMinimum(double[] array){
        Min m = new Min();
        double minimum = m.evaluate(array);
        return minimum;
    }

    public double getMaximum(double[] array){
        Max m = new Max();
        double maximum = m.evaluate(array);
        return maximum;
    }

    public double getMedian(double[] array){
        Median m = new Median();
        double median = m.evaluate(array);
        return median;
    }

    public double getMean(double[] array){
        Mean m = new Mean();
        double mean = m.evaluate(array);
        return mean;
    }

    public double getStandardDeviation(double[] array){
        StandardDeviation m = new StandardDeviation();
        double std = m.evaluate(array);
        return std;
    }

    public double[] getStats(double[] array){
        double minimum = this.getMinimum(array);
        double maximum = this.getMaximum(array);
        double median = this.getMedian(array);
        double mean = this.getMean(array);
        double std = this.getStandardDeviation(array);
        double[] stats = {minimum, maximum, median, mean, std};
        return stats;
    }

    public static void main(String[] args){
        double[] array = {-1.0,-1.2,-7.0,1.0,-16.0,1.0,1.0,-4.0, -1.3, 1.0,2.0, 15.0, 4.0, 5.0};
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
