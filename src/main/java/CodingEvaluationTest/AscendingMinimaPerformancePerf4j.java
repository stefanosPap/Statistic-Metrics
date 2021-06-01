package analytics.testing.PerformanceTest.AscendingMinima;

import analytics.testing.CodingEvaluation.AscendingMinimaOptimized;
import analytics.testing.CodingEvaluation.AscendingMinima;
import analytics.testing.CodingEvaluation.AscendingMinimaOptimized;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

// Open a terminal and go to /analytics-platform/testing-module/src/main/java/analytics/testing/CodingEvaluation directory
// Then run java -jar perf4j-0.9.16.jar --graph per4jgraph.html log.out in order to see the results

public class AscendingMinimaPerformancePerf4j {

    private final static Logger logger = LogManager.getLogger(AscendingMinimaPerformancePerf4j.class);

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

        logger.info("Start testing");

        StopWatch stopWatch;

        stopWatch = new LoggingStopWatch("ascendingMinima");
        for (int i=0; i<reps; i++) {
            AscendingMinima.ascendingMinima(array, minima);
        }
        logger.info("ascendingMinima execution");
        System.out.println(stopWatch.stop());

        stopWatch = new LoggingStopWatch("ascendingMinimaShift");
        for (int i=0; i<reps; i++) {
            AscendingMinima.ascendingMinimaShift(previous_window, new_element, previous_minima);
        }
        logger.info("ascendingMinimaShift execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("ascendingMinimaOptimized");
        for (int i=0; i<reps; i++) {
            AscendingMinimaOptimized.ascendingMinimaOptimized(array, minimaDeque);
        }
        logger.info("ascendingMinimaOptimized execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("ascendingMinimaOptimizedShift");
        for (int i=0; i<reps; i++) {
            AscendingMinimaOptimized.ascendingMinimaOptimizedShift(previous_window, new_element, previous_minima_deque);
        }
        logger.info("ascendingMinimaOptimizedShift execution");
        stopWatch.stop();
    }
}
