package analytics.testing.PerformanceTest.MathUtils;

import analytics.testing.CodingEvaluation.StatisticUtilsArray;
import analytics.testing.CodingEvaluation.StatisticUtilsArrayStreams;
import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;

import java.util.Random;

public class MathUtilsPerformanceJavaSimon {

    public static void main(String[] args) {

        double[] arrayWarmUp = new double[100];
        double[] array = new double[200_000];
        int repsWarmUp = 10_000;
        int reps = 1;

        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextDouble();
            if (i < arrayWarmUp.length){
                arrayWarmUp[i] = rand.nextDouble();
            }
        }

        // warm-up
        for (int i=0; i<repsWarmUp; i++){
            StatisticUtilsArray.getMinimum(arrayWarmUp);
            StatisticUtilsArray.getMaximum(arrayWarmUp);
            StatisticUtilsArray.getMedian(arrayWarmUp);
            StatisticUtilsArray.getMean(arrayWarmUp);
            StatisticUtilsArray.getStandardDeviation(arrayWarmUp);
            StatisticUtilsArrayStreams.getMinimum(arrayWarmUp);
            StatisticUtilsArrayStreams.getMaximum(arrayWarmUp);
            StatisticUtilsArrayStreams.getMean(arrayWarmUp);
            StatisticUtilsArrayStreams.getMedian(arrayWarmUp);
            StatisticUtilsArrayStreams.getStandardDeviation(arrayWarmUp);
        }

        Stopwatch stopwatch;
        Split split;

        stopwatch = SimonManager.getStopwatch("minimum");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMinimum(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("minimumStreams");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMinimum(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("maximum");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMaximum(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("maximumStreams");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMaximum(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("median");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMedian(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("medianStreams");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMedian(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("mean");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMean(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("meanStreams");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMean(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("std");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getStandardDeviation(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");

        stopwatch = SimonManager.getStopwatch("stdStreams");
        split = stopwatch.start();
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getStandardDeviation(array);
        }
        System.out.println(split.stop());
        System.out.println(stopwatch);
        System.out.println(stopwatch.sample() + "\n");
    }}
