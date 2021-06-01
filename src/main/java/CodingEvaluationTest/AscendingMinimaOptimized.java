package CodingEvaluationTest;

import java.util.*;
import org.apache.commons.lang3.*;
import org.openjdk.jmh.annotations.*;

/**
 * Implements Ascending Minima Algorithm
 * @author Stefanos Papadam
 */
public class AscendingMinimaOptimized {

    /**
     * Constructor
     */
    public AscendingMinimaOptimized(){}

    /**
     * Calculates ascending minima array for a window of size length
     * @see <a href="http://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html">Ascending Minima Algorithm</a>
     * @return minima ascending array
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(1)
    @Measurement(iterations = 1)
    @Warmup(iterations = 1)
    public Deque<Integer> ascendingMinimaOptimized(BenchmarkRunner.StateObj state) {
        int[] arr = state.arr;
        Deque<Integer> minima = state.minimaDeque;

        /**
         * Calculates ascending minima array for a window of size length
         *
         * @param arr    window to calculate its minima ascending array
         * @param minima minima ascending array
         *
         * @return minima ascending array
         */

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
                minima.add(minimum);

            } while (minimum != termination);

            return minima;
        }

        /**
         * Calculates new minima ascending array if window shifted right by one new element
         *
         *
         * @return updated minima ascending array
         */
        @Benchmark
        @BenchmarkMode(Mode.Throughput)
        @Fork(1)
        @Measurement(iterations = 1)
        @Warmup(iterations = 1)
        public Deque<Integer> ascendingMinimaOptimizedShift(BenchmarkRunner.StateObj state) {
            Deque<Integer>  previous_minima = state.previous_minima_deque;
            int[] previous_window = state.previous_window;

            //delete previous minima's first element in case of equality
            previous_minima = removeFirstElement(previous_window, previous_minima);

            // remove backwards all elements greater than the new added element from previous minima
            previous_minima = removeBackwards(previous_minima, state.new_element);

            //append new element to minima
            previous_minima.add(state.new_element);

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
        private Deque<Integer> removeFirstElement(int[] previous_window, Deque<Integer> previous_minima) {

            //delete previous minima's first element in case of equality
            if (previous_window[0] == previous_minima.peek() && previous_minima.size() != 1) {
                previous_minima.remove();
            }
            return previous_minima;
        }

        /**
         * Removes backwards all the elements greater than the new added element from previous minima
         *
         * @param previous_minima minima ascending array before element insertion
         * @param new_element     element to be added in the window
         */
        private Deque<Integer> removeBackwards(Deque<Integer> previous_minima, int new_element) {

            // remove backwards all elements greater than the new added element from previous minima
            while (previous_minima.getLast() >= new_element) {
                previous_minima.removeLast();

                // case of previous_minima.length = 1
                if (previous_minima.isEmpty()) {
                    break;
                }
            }
            return previous_minima;
        }
}