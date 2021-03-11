import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticUtilsArrayTest {
    double[] array = {1.0,2.0,3.0,4.0,5.0,6.0};
    StatisticUtilsArray stat = new StatisticUtilsArray();

    @Test
    void testGetMinimum(){
        assertEquals(1.0, stat.getMinimum(array));
    }
    @Test
    void testGetMaximum(){
        assertEquals(6.0, stat.getMaximum(array));
    }
    @Test
    void testGetMean(){
        assertEquals(3.5, stat.getMean(array));
    }
    @Test
    void testGetMedian(){
        assertEquals(3.5, stat.getMedian(array));
    }
    @Test
    void testGetStd(){
        assertEquals(1.8708286933869707, stat.getStandardDeviation(array));
    }
}