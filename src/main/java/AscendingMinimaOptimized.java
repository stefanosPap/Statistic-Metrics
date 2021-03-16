import java.util.*;
import java.util.stream.IntStream;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.time.StopWatch;

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
     * @param arr window to calculate its minima ascending array
     * @param length initial window's length
     * @param minima minima ascending array
     * @return minima ascending array
     */
    public  Deque<Integer> AscendingMinimaOptimized(int[] arr, int length,  Deque<Integer> minima) {

        //recursion's end conditions
        if (arr.length == 0) return minima;
        if (arr.length == 1) {
            minima.add(arr[0]); // append first element to minima
            return minima;
        }

        int min_index;
        int minimum = Arrays.stream(arr).min().getAsInt(); //find minimum of window
        min_index = ArrayUtils.indexOf(arr, minimum); //find index of minimum element

        // in case of minimum duplicates this while loop updates min_index to the last index that contains current minimum value
        while (true) {
            // isolate window's elements from min_index + 1 to window_length - 1
            int[] slice = new int[arr.length - min_index - 1];
            for (int i = 0; i < slice.length; i++) {
                slice[i] = arr[min_index + 1 + i];
            }
            arr = slice;

            // if minimum in window then update min index to the minimum's last index
            if (IntStream.of(arr).anyMatch(x -> x == minimum)) {
                min_index = ArrayUtils.indexOf(arr, minimum);
            }
            else{
                break;
            }

        }
        minima.add(minimum);  //append minimum to minima
        minima = AscendingMinimaOptimized(arr, length, minima); //recursively call minima
        return minima;
    }

    /**
     * Overload method of AscendingMinimaOptimized in order to pass default value for minima variable
     * @param arr window to calculate its minima ascending array
     * @param length initial window's length
     * @return minima ascending array
     */
    public Deque<Integer> AscendingMinimaOptimized(int[] arr, int length){
        Deque<Integer> minima = new LinkedList<>();
        minima = this.AscendingMinimaOptimized(arr, length, minima);
        return minima;
    }

    /**
     * Calculates new minima ascending array if window shifted right by one new element
     * @see <a href="http://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html">Ascending Minima Algorithm</a>
     * @param previous_window previous window before shifting
     * @param new_element element to add in the window
     * @param previous_minima minima ascending array before element insertion
     * @return updated minima ascending array
     */

    public Deque<Integer> AscendingMinimaOptimizedShift(int[] previous_window, int new_element, Deque<Integer> previous_minima) {
        if (previous_window[0] == previous_minima.peek() && previous_minima.size() != 1) {
            //delete previous minima's first element in case of equality
            previous_minima.remove();
        }
        if (previous_minima.size() - 1 > 0) {
            Integer temp = previous_minima.getLast();
            // while loop for removing backwards all elements greater than the new added element from previous minima
            while (temp >= new_element) {
                previous_minima.removeLast();
                if (previous_minima.size() == 0) {
                    break;
                }
                temp = previous_minima.getLast();
            }
        }
        else{
            if (previous_minima.peek() >= new_element) {
                previous_minima.remove(); //delete previous minima's first element in case of equality
            }
        }
        previous_minima.add(new_element); //append new element to minima

        return previous_minima;
    }

    /**
     * Tests ascending minima algorithm operation
     * @param args command-line arguments
     */
    public static void main(String[] args){
        StopWatch watch = new StopWatch();
        watch.start();
        AscendingMinimaOptimized asc = new AscendingMinimaOptimized();

        // first example for calculating ascending minima window1
        int[] window1 = {8,9,5,3,6,5,1,1,0};
        /*
        BinaryTree window1 = new BinaryTree();
        window1.insert(8);
        window1.insert(9);
        window1.insert(5);
        window1.insert(3);
        window1.insert(6);
        window1.insert(5);
        window1.insert(1);
        window1.insert(1);
        window1.insert(2);
        */
        Deque<Integer> minima1 = asc.AscendingMinimaOptimized(window1, window1.length);

        System.out.print("window is: ");
        for (int j : window1) {
            System.out.print(" "+j);
        }
        System.out.print("\n");

        System.out.print("minima is: ");
        for (int j : minima1) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("\n");

        // second example for calculating ascending minima window2
        int[] window2 = {7,4,8,6,3,4,2,1,2};
        Deque<Integer> minima2 = asc.AscendingMinimaOptimized(window2, window2.length);
        System.out.print("window is: ");
        for (int j : window2) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("minima is: ");
        for (int j : minima2) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("\n");

        // third example for calculating ascending minima window3
        int[] window3 = {1,2,3,4,5,6,7,8,9};
        Deque<Integer> minima3 = asc.AscendingMinimaOptimized(window3, window3.length);
        System.out.print("window is: ");
        for (int j : window3) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("minima is: ");
        for (int j : minima3) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("\n");

        // forth example for calculating ascending minima window4
        int[] window4 = {9,8,7,6,5,4,3,2,1};
        Deque<Integer> minima4 = asc.AscendingMinimaOptimized(window4, window4.length);
        System.out.print("window is: ");
        for (int j : window4) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("minima is: ");
        for (int j : minima4) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("\n");

        // fifth example for calculating ascending minima window5
        int[] window5 = {9,1,1,3,4,2,6,8,9};
        Deque<Integer> minima5 = asc.AscendingMinimaOptimized(window5, window5.length);
        System.out.print("window is: ");
        for (int j : window5) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        System.out.print("minima is: ");
        for (int j : minima5) {
            System.out.print(" "+j);
        }
        System.out.print("\n");

        System.out.println("-----------------------------");

        // example for calculating ascending minima window6 and updating it by inserting 6, 10, 0 values
        int[] window6 = {1,3,3,2,5,8,7,8,9,2,3,4,5,6,7,8,5,3,2,0,4,1};
        Deque<Integer> minima = asc.AscendingMinimaOptimized(window6, window6.length);
        System.out.print("minima is: ");
        for (int j : minima) {
            System.out.print(" "+j);
        }
        System.out.print("\n");

        System.out.print("If window moves and adds 6 at the right, then minima becomes:");
        Deque<Integer> minima6 = new LinkedList<>(minima);
        Deque<Integer> result1 = asc.AscendingMinimaOptimizedShift(window6, 6, minima6);
        for (int j : result1) {
            System.out.print(" "+j);
        }
        System.out.print("\n");

        System.out.print("If window moves and adds 10 at the right, then minima becomes: ");
        Deque<Integer> minima7 = new LinkedList<>(minima);
        Deque<Integer> result2 = asc.AscendingMinimaOptimizedShift(window6, 10, minima7);
        for (int j : result2) {
            System.out.print(" "+j);
        }
        System.out.print("\n");

        System.out.print("If window moves and adds 0 at the right, then minima becomes: ");
        Deque<Integer> minima8 = new LinkedList<>(minima);
        Deque<Integer> result3 = asc.AscendingMinimaOptimizedShift(window6, 0, minima8);
        for (int j : result3) {
            System.out.print(" "+j);
        }
        System.out.print("\n");
        watch.stop();
        System.out.println(watch.getTime());

    }
}


