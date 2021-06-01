package analytics.testing.PerformanceTest.AscendingMinima;

import analytics.testing.CodingEvaluation.AscendingMinima;
import analytics.testing.CodingEvaluation.AscendingMinimaOptimized;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.ConsoleReportGenerator;
import org.junit.Rule;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class AscendingMinimaPerformanceJUnitPerf {

    private static final int[] array = new int[200_000];
    private static final int[] minima = {};
    private static final int[] previous_window = new int[200_000];
    private static final int new_element = 6;
    private static final int[] previous_minima;
    private static final Deque<Integer> minimaDeque = new LinkedList<>();
    private static final Deque<Integer> previous_minima_deque;

    static {

        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
            previous_window[i] = rand.nextInt();
        }

        previous_minima = AscendingMinima.ascendingMinima(previous_window, minima);
        previous_minima_deque = AscendingMinimaOptimized.ascendingMinimaOptimized(previous_window, minimaDeque);
    }

    @Rule
    public JUnitPerfRule jUnitPerfRule = new JUnitPerfRule(new ConsoleReportGenerator());

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void ascendingMinimaTest() {
        AscendingMinima.ascendingMinima(array, minima);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void ascendingMinimaShiftTest() {
        AscendingMinima.ascendingMinimaShift(previous_window, new_element, previous_minima);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void ascendingMinimaOptimizedTest() {
        AscendingMinimaOptimized.ascendingMinimaOptimized(array, minimaDeque);
    }

    @Test
    @JUnitPerfTest(warmUpMs = 1_000, durationMs = 2_000)
    public void ascendingMinimaOptimizedShiftTest() {
        AscendingMinimaOptimized.ascendingMinimaOptimizedShift(previous_window, new_element, previous_minima_deque);
    }
}

