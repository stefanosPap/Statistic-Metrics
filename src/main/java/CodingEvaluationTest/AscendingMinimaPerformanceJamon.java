package analytics.testing.PerformanceTest.AscendingMinima;

import analytics.testing.CodingEvaluation.AscendingMinima;
import analytics.testing.CodingEvaluation.AscendingMinimaOptimized;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class AscendingMinimaPerformanceJamon {

    public static void main(String[] args) {

        int[] arrayWarmUp = new int[100];
        int[] array = new int[200_000];
        int[] minima = {};
        int[] previous_window = new int[200_000];
        int new_element = 6;
        int[] previous_minima;
        Deque<Integer> minimaDeque = new LinkedList<>();
        Deque<Integer> previous_minima_deque;
        int repsWarmUp = 10_000;
        int reps = 1_000;

        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
            previous_window[i] = rand.nextInt();
            if (i < arrayWarmUp.length){
                arrayWarmUp[i] = rand.nextInt();
            }
        }

        previous_minima = AscendingMinima.ascendingMinima(previous_window, minima);
        previous_minima_deque = AscendingMinimaOptimized.ascendingMinimaOptimized(previous_window, minimaDeque);

        // warm-up
        for (int i=0; i<repsWarmUp; i++){
            AscendingMinima.ascendingMinima(arrayWarmUp, minima);
            AscendingMinima.ascendingMinimaShift(previous_window, new_element, previous_minima);
            AscendingMinimaOptimized.ascendingMinimaOptimized(arrayWarmUp, minimaDeque);
            AscendingMinimaOptimized.ascendingMinimaOptimizedShift(previous_window, new_element, previous_minima_deque);
        }

        Monitor mon;

        mon = MonitorFactory.start("ascendingMinima");
        for (int i=0; i<reps; i++) {
            AscendingMinima.ascendingMinima(array, minima);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("ascendingMinimaShift");
        for (int i=0; i<reps; i++) {
            AscendingMinima.ascendingMinimaShift(previous_window, new_element, previous_minima);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("ascendingMinimaOptimized");
        for (int i=0; i<reps; i++) {
            AscendingMinimaOptimized.ascendingMinimaOptimized(array, minimaDeque);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("ascendingMinimaOptimizedShift");
        for (int i=0; i<reps; i++) {
            AscendingMinimaOptimized.ascendingMinimaOptimizedShift(previous_window, new_element, previous_minima_deque);
        }
        System.out.println(mon.stop() + "\n");

    }
}
