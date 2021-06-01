package analytics.testing.PerformanceTest.MathUtils;

import analytics.testing.CodingEvaluation.StatisticUtilsArray;
import analytics.testing.CodingEvaluation.StatisticUtilsArrayStreams;
import com.jamonapi.*;

import java.util.Random;


public class MathUtilsPerformanceJamon {

    public static void main(String[] args) {

        double[] arrayWarmUp = new double[100];
        double[] array = new double[100_000];
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

        Monitor mon;

        mon = MonitorFactory.start("minimum");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMinimum(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("minimumStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMinimum(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("maximum");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMaximum(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("maximumStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMaximum(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("mean");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMean(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("meanStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMean(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("median");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMedian(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("medianStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMedian(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("std");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getStandardDeviation(array);
        }
        System.out.println(mon.stop() + "\n");

        mon = MonitorFactory.start("std");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getStandardDeviation(array);
        }
        System.out.println(mon.stop() + "\n");
    }
}
