package analytics.testing.PerformanceTest.MathUtils;

import analytics.testing.CodingEvaluation.StatisticUtilsArray;
import analytics.testing.CodingEvaluation.StatisticUtilsArrayStreams;
import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import etm.core.renderer.SimpleTextRenderer;

import java.util.Random;

public class MathUtilsPerformanceJTEM {

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

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

        EtmPoint point;
        EtmMonitor monitor;
        BasicEtmConfigurator.configure();
        monitor = EtmManager.getEtmMonitor();

        monitor.start();

        point = etmMonitor.createPoint("getMinimum");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArray.getMinimum(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMinimumStreams");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArrayStreams.getMinimum(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMaximum");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArray.getMaximum(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMaximumStreams");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArrayStreams.getMaximum(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMean");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArray.getMean(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMeanStreams");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArrayStreams.getMean(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMedian");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArray.getMedian(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getMedianStreams");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArrayStreams.getMedian(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getStd");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArray.getStandardDeviation(array);
            }
        } finally {
            point.collect();
        }

        point = etmMonitor.createPoint("getStdStreams");
        try {
            for (int i = 0; i < reps; i++) {
                StatisticUtilsArrayStreams.getStandardDeviation(array);
            }
        } finally {
            point.collect();
        }

        monitor.stop();

        etmMonitor.render(new SimpleTextRenderer());

    }
}
