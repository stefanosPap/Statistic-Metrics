package CodingEvaluationTest;

import java.util.ArrayList;
import static org.apache.commons.lang3.ArrayUtils.*;

/**
 * Statistical metrics for an ArrayList of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayListStreams{

    public StatisticUtilsArrayListStreams(){
    }

    /**
     * Converts ArrayList to Array in order to use parent class's
     * @param arraylist arraylist to be converted to array
     * @return converted array
     */
    public double[] convertArrayListToArray(ArrayList<Double> arraylist) {
        Double[] Array = arraylist.toArray(new Double[0]);
        return toPrimitive(Array);
    }

    /**
     * Tests ArrayList's metrics that provided by StatisticUtilsArrayList
     * @param args command-line arguments
     */
    public static void main(String[] args){

        ArrayList<Double> arraylist = new ArrayList<>();
        arraylist.add(1.0);
        arraylist.add(2.0);
        arraylist.add(3.0);
        arraylist.add(4.0);
        arraylist.add(5.0);
        arraylist.add(6.0);

        StatisticUtilsArrayListStreams stats = new StatisticUtilsArrayListStreams();
        double[] array = stats.convertArrayListToArray(arraylist);


    }
}
