package analytics.testing.PerformanceTest.MathUtils;

import analytics.testing.CodingEvaluation.StatisticUtilsArray;
import analytics.testing.CodingEvaluation.StatisticUtilsArrayStreams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import java.util.Random;

// Open a terminal and go to /analytics-platform/testing-module/src/main/java/analytics/testing/CodingEvaluation directory
// Then run java -jar perf4j-0.9.16.jar --graph per4jgraph.html log.out in order to see the results

public class MathUtilsPerformancePerf4j {
    private final static Logger logger = LogManager.getLogger(MathUtilsPerformancePerf4j.class);

    public static void main(String[] args) {

        double[] arrayWarmUp = new double[100];
        double[] array = new double[1_000];
        int repsWarmUp = 10_000;
        int reps = 1_000_000;

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

        logger.info("Start testing");

        StopWatch stopWatch;

        stopWatch = new LoggingStopWatch("minimum");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMinimum(array);
        }
        logger.info("Minimum execution");
        System.out.println(stopWatch.stop());

        stopWatch = new LoggingStopWatch("minimumStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMinimum(array);
        }
        logger.info("Minimum Streams execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("maximum");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMaximum(array);
        }
        logger.info("Maximum execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("maximumStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMaximum(array);
        }
        logger.info("Maximum Streams execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("mean");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMean(array);
        }
        logger.info("Mean execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("meanStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMean(array);
        }
        logger.info("Mean Streams execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("median");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getMedian(array);
        }
        logger.info("Median execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("medianStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArrayStreams.getMedian(array);
        }
        logger.info("Median Streams execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("std");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getStandardDeviation(array);
        }
        logger.info("Std execution");
        stopWatch.stop();

        stopWatch = new LoggingStopWatch("stdStreams");
        for (int i=0; i<reps; i++) {
            StatisticUtilsArray.getStandardDeviation(array);
        }
        logger.info("Std Streams execution");
        stopWatch.stop();
    }
}
