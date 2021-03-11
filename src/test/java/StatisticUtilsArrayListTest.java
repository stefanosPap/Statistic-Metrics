import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class StatisticUtilsArrayListTest {
    double[] array = {1.0,2.0,3.0,4.0,5.0,6.0};
    StatisticUtilsArrayList stat = new StatisticUtilsArrayList();
    ArrayList<Double> arraylist = new ArrayList<>();

    @Test
    void testConvert(){
        arraylist.add(1.0);
        arraylist.add(2.0);
        arraylist.add(3.0);
        arraylist.add(4.0);
        arraylist.add(5.0);
        arraylist.add(6.0);
        assertArrayEquals(array, stat.convertArrayListToArray(arraylist));
    }
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