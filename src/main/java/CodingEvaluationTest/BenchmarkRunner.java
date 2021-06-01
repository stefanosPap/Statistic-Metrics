package CodingEvaluationTest;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkRunner {

    @State(Scope.Thread)
    public static class StateObj {
        public double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};

        public int[] arr = {7, 4, 8, 6, 3, 4, 2, 1 ,2};
        public int[] minima = {};
        public int[] previous_window = {1, 3, 3, 2, 5, 8, 7, 8, 9};
        public int new_element = 6;
        int[] previous_minima = {1, 2, 5, 7, 8, 9};
        Deque<Integer> minimaDeque = new LinkedList<>();
        Deque<Integer> previous_minima_deque = new LinkedList<>(List.of(1, 2, 5, 7, 8, 9));
    }

    public static void main(String[] args) throws RunnerException {
        /*
        Options opt = new OptionsBuilder()
                .include(AscendingMinima.class.getSimpleName())
                .build();
        new Runner(opt).run();
        */
        Options opt = new OptionsBuilder()
                .include(AscendingMinimaOptimized.class.getSimpleName())
                .build();
        new Runner(opt).run();

    }
}
