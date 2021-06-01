package CodingEvaluationTest;

import java.util.ArrayList;

import static org.apache.commons.lang3.ArrayUtils.*;

/**
 * Statistical metrics for an ArrayList of doubles
 * @author Stefanos Papadam
 */
public class StatisticUtilsArrayList{

    /**
     * Converts ArrayList to Array in order to use parent class's
     *
     * @param arraylist arraylist to be converted to array
     *
     * @return converted array
     */
    static double[] convertArrayListToArray(ArrayList<Double> arraylist) {

        return arraylist.stream().mapToDouble(i -> i).toArray();
    }

}
