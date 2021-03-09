import java.util.ArrayList;
import org.apache.commons.lang3.*;

import static org.apache.commons.lang3.ArrayUtils.*;

public class StatisticUtilsArrayList extends StatisticUtilsArray{

    private ArrayList<Double> arraylist;

    public StatisticUtilsArrayList(ArrayList<Double> arraylist){
        this.setArraylist(arraylist);
    }

    public void setArraylist(ArrayList<Double> arraylist){
        this.arraylist = arraylist;
    }

    public double[] convertArrayListToArray(ArrayList<Double> arraylist) {
        Double[] Array = arraylist.toArray(new Double[arraylist.size()]);
        double[] array = toPrimitive(Array);
        return array;
    }

    public static void main(String[] args){

        ArrayList<Double> arraylist = new ArrayList<>();
        arraylist.add(1.0);
        arraylist.add(2.0);
        StatisticUtilsArrayList stats = new StatisticUtilsArrayList(arraylist);
        double[] array = stats.convertArrayListToArray(arraylist);

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
