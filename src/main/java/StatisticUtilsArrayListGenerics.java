import java.util.ArrayList;
import java.util.Random;

/**
 * Statistical metrics for an ArrayList of doubles using Generics for handling all numerical types
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayListGenerics<T> extends StatisticUtilsArray{

    private final ArrayList<T> arraylist;

    /**
     * Constructor
     * @param arraylist values provided for metrics calculation
     */
    public StatisticUtilsArrayListGenerics(ArrayList<T> arraylist){
        this.arraylist = arraylist;
    }

    /**
     * Converts arraylist to double[] array in order to use parent class's
     * @return converted array
     */
    public double[] getDoubleValues() {
        double[] result = new double[arraylist.size()];
        Number num;
        for (int i=0; i<arraylist.size(); i++) {
            num = (Number) arraylist.get(i);
            result[i] = num.doubleValue();
        }
        return result;
    }
    /**
     * Tests ArrayList's metrics that provided by StatisticUtilsArrayList
     * @param args command-line arguments
     */
    public static void main(String[] args){

        Random rand = new Random();

        ArrayList<Float> arraylistFloat = new ArrayList<>();
        arraylistFloat.add(rand.nextFloat());
        arraylistFloat.add(rand.nextFloat());
        arraylistFloat.add(rand.nextFloat());
        arraylistFloat.add(rand.nextFloat());
        arraylistFloat.add(rand.nextFloat());
        arraylistFloat.add(rand.nextFloat());
        StatisticUtilsArrayListGenerics<Float> statsFloat = new StatisticUtilsArrayListGenerics<>(arraylistFloat);

        double[] array = statsFloat.getDoubleValues();

        double minimum = statsFloat.getMinimum(array);
        double maximum = statsFloat.getMaximum(array);
        double median = statsFloat.getMedian(array);
        double mean = statsFloat.getMean(array);
        double std = statsFloat.getStandardDeviation(array);

        System.out.println("Metrics for Float type:\n");
        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Median value: " + median);
        System.out.println("Mean value: " + mean);
        System.out.println("Standard deviation value: " + std + "\n");
        System.out.println("--------------------------------\n");

        ArrayList<Double> arraylistDouble = new ArrayList<>();
        arraylistDouble.add(rand.nextDouble());
        arraylistDouble.add(rand.nextDouble());
        arraylistDouble.add(rand.nextDouble());
        arraylistDouble.add(rand.nextDouble());
        arraylistDouble.add(rand.nextDouble());
        arraylistDouble.add(rand.nextDouble());
        StatisticUtilsArrayListGenerics<Double> statsDouble = new StatisticUtilsArrayListGenerics<>(arraylistDouble);

        array = statsDouble.getDoubleValues();

        minimum = statsDouble.getMinimum(array);
        maximum = statsDouble.getMaximum(array);
        median = statsDouble.getMedian(array);
        mean = statsDouble.getMean(array);
        std = statsDouble.getStandardDeviation(array);

        System.out.println("Metrics for Double type:\n");
        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Median value: " + median);
        System.out.println("Mean value: " + mean);
        System.out.println("Standard deviation value: " + std + "\n");
        System.out.println("--------------------------------\n");

        ArrayList<Integer> arraylistInteger = new ArrayList<>();
        arraylistInteger.add(rand.nextInt());
        arraylistInteger.add(rand.nextInt());
        arraylistInteger.add(rand.nextInt());
        arraylistInteger.add(rand.nextInt());
        arraylistInteger.add(rand.nextInt());
        arraylistInteger.add(rand.nextInt());
        StatisticUtilsArrayListGenerics<Integer> statsInteger = new StatisticUtilsArrayListGenerics<>(arraylistInteger);

        array = statsInteger.getDoubleValues();

        minimum = statsInteger.getMinimum(array);
        maximum = statsInteger.getMaximum(array);
        median = statsInteger.getMedian(array);
        mean = statsInteger.getMean(array);
        std = statsInteger.getStandardDeviation(array);

        System.out.println("Metrics for Integer type:\n");
        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Median value: " + median);
        System.out.println("Mean value: " + mean);
        System.out.println("Standard deviation value: " + std + "\n");
        System.out.println("--------------------------------\n");

        ArrayList<Long> arraylistLong = new ArrayList<>();
        arraylistLong.add(rand.nextLong());
        arraylistLong.add(rand.nextLong());
        arraylistLong.add(rand.nextLong());
        arraylistLong.add(rand.nextLong());
        arraylistLong.add(rand.nextLong());
        arraylistLong.add(rand.nextLong());
        StatisticUtilsArrayListGenerics<Long> statsLong = new StatisticUtilsArrayListGenerics<>(arraylistLong);

        array = statsLong.getDoubleValues();

        minimum = statsLong.getMinimum(array);
        maximum = statsLong.getMaximum(array);
        median = statsLong.getMedian(array);
        mean = statsLong.getMean(array);
        std = statsLong.getStandardDeviation(array);

        System.out.println("Metrics for Long type:\n");
        System.out.println("Minimum value: " + minimum);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Median value: " + median);
        System.out.println("Mean value: " + mean);
        System.out.println("Standard deviation value: " + std + "\n");
        System.out.println("--------------------------------\n");
    }
}
