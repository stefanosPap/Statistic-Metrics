package CodingEvaluationTest;

import java.util.*;

import org.apache.commons.lang3.*;
import org.openjdk.jmh.annotations.*;

/**
 * Implements Ascending Minima Algorithm
 *
 * @author Stefanos Papadam
 */
public class AscendingMinima {

    /**
     * Constructor
     */
    public AscendingMinima() {

    }

    /**
     * Calculates ascending minima array for a window of size length
     *
     * @return minima ascending array
     *
     * @see <a href="http://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html">Ascending Minima Algorithm</a>
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int[] ascendingMinima(BenchmarkRunner.StateObj state) {

        int[] arr = state.arr;
        int[] minima = state.minima;
        // variable for terminating while loop

        int termination = arr[arr.length - 1];

        int minimum;

        do {

            //find minimum of window
            minimum = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);

            //find index of minimum element
            int min_index = ArrayUtils.lastIndexOf(arr, minimum);

            // crop array in order to find next minimum
            arr = Arrays.stream(arr).skip(min_index + 1).toArray();

            //append minimum to minima
            minima = ArrayUtils.add(minima, minimum);

        }
        while (minimum != termination);

        return minima;
    }

    /**
     * Calculates new minima ascending array if window shifted right by one new element
     *
     * @return updated minima ascending array
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int[] ascendingMinimaShift(BenchmarkRunner.StateObj state) {
        int[] previous_minima = state.previous_minima;
        int[] previous_window = state.previous_window;

        //delete previous minima's first element in case of equality
        previous_minima = removeFirstElement(previous_window, previous_minima);

        // remove backwards all elements greater than the new added element from previous minima
        previous_minima = removeBackwards(previous_minima, state.new_element);

        //append new element to minima
        previous_minima = ArrayUtils.add(previous_minima, state.new_element);

        return previous_minima;
    }

    /**
     * Removes first element of the previous window in case of its first element is equal to previous minima's first element
     *
     * @param previous_window previous window before shifting
     * @param previous_minima minima ascending array before element insertion
     *
     * @return updated minima ascending array
     */
    private int[] removeFirstElement(int[] previous_window, int[] previous_minima) {

        //delete previous minima's first element in case of equality
        if (previous_window[0] == previous_minima[0] && previous_minima.length != 1) {
            previous_minima = ArrayUtils.remove(previous_minima, 0);
        }
        return previous_minima;
    }

    /**
     * Removes backwards all the elements greater than the new added element from previous minima
     *
     * @param previous_minima minima ascending array before element insertion
     * @param new_element     element to be added in the window
     */
    private int[] removeBackwards(int[] previous_minima, int new_element) {

        // remove backwards all elements greater than the new added element from previous minima
        while (previous_minima[previous_minima.length - 1] >= new_element) {
            previous_minima = ArrayUtils.remove(previous_minima, previous_minima.length - 1);

            // case of previous_minima.length = 1
            if (previous_minima.length == 0) {
                break;
            }
        }
        return previous_minima;
    }
}

