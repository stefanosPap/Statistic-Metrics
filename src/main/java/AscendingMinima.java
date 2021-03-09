import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.*;

public class AscendingMinima {

    public int[] ascending_minima(int[] arr,int length,int[] minima) {
        if (arr.length == 0) return minima;
        if (arr.length == 1) {
            minima = ArrayUtils.add(minima, arr[0]);
            return minima;
        }
        int min_index = 0;
        int minimum = Arrays.stream(arr).min().getAsInt();

        min_index = ArrayUtils.indexOf(arr, minimum);
        while (true) {
            //arr = Arrays.copyOfRange(arr, min_index + 1, length);
            int[] slice = new int[arr.length - min_index - 1];
            // Copy elements of arr to slice
            for (int i = 0; i < slice.length; i++) {
                slice[i] = arr[min_index + 1 + i];
            }
            arr = slice;
            if (IntStream.of(arr).anyMatch(x -> x == minimum)) {
                int last_min = ArrayUtils.indexOf(arr, minimum);
                min_index = min_index + last_min + 1;
            } else {
                break;
            }

        }
        minima = ArrayUtils.add(minima, minimum);
        minima = ascending_minima(arr, length, minima);
        return minima;
    }

        public int[] ascending_minima( int[] arr, int length){
            int[] minima = {};
            minima = this.ascending_minima(arr, length, minima);
            return minima;
        }

        public int[] ascending_minima_shift(int[] previous_window,int new_element,int[] previous_minima) {
            if (previous_window[0] == previous_minima[0]) {
                previous_minima = ArrayUtils.remove(previous_minima, 0);
            }
            while (previous_minima[previous_minima.length - 1] > new_element) {
                previous_minima = ArrayUtils.remove(previous_minima, previous_minima.length - 1);

                if (previous_minima.length == 0) {
                    break;
                }

            }
            previous_minima = ArrayUtils.add(previous_minima, new_element);
            return previous_minima;
        }
        public static void main(String[] args){
            AscendingMinima asc = new AscendingMinima();


            int[] window1 = {8,9,5,3,6,5,1,1,0};
            int[] minima1 = asc.ascending_minima(window1, window1.length);
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

            int[] window2 = {7,4,8,6,3,4,2,1,2};
            int[] minima2 = asc.ascending_minima(window2, window2.length);
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

            int[] window3 = {1,2,3,4,5,6,7,8,9};
            int[] minima3 = asc.ascending_minima(window3, window3.length);
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

            int[] window4 = {9,8,7,6,5,4,3,2,1};
            int[] minima4 = asc.ascending_minima(window4, window4.length);
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

            int[] window5 = {9,1,1,3,4,2,6,8,9};
            int[] minima5 = asc.ascending_minima(window5, window5.length);
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

            int[] window6 = {1,3,3,2,5,8,7,8,9};
            int[] minima6 = asc.ascending_minima(window6, window6.length);
            System.out.print("minima is: ");
            for (int j : minima6) {
                System.out.print(" "+j);
            }
            System.out.print("\n");

            System.out.print("If window moves and adds 6 at the right, then minima becomes:");
            int[] result1 = asc.ascending_minima_shift(window6, 6, minima6);
            for (int j : result1) {
                System.out.print(" "+j);
            }
            System.out.print("\n");

            System.out.print("If window moves and adds 10 at the right, then minima becomes: ");
            int[] result2 = asc.ascending_minima_shift(window6, 10, minima6);
            for (int j : result2) {
                System.out.print(" "+j);
            }
            System.out.print("\n");

            System.out.print("If window moves and adds 0 at the right, then minima becomes: ");
            int[] result3 = asc.ascending_minima_shift(window6, 0, minima6);
            for (int j : result3) {
                System.out.print(" "+j);
            }
        }
}

