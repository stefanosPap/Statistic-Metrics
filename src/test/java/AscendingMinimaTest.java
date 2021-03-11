import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AscendingMinimaTest {

    AscendingMinima asc = new AscendingMinima();

    @Test
    void testGetAscendingMinimaShift(){
        int[] window = {1,3,3,2,5,8,7,8,9};
        int[] minima = {1,2,5,7,8,9};
        int[] expected1 = {2,5,6};
        assertArrayEquals(expected1, asc.ascendingMinimaShift(window, 6, minima));
        int[] expected2 = {2,5,7,8,9,10};
        assertArrayEquals(expected2, asc.ascendingMinimaShift(window, 10, minima));
        int[] expected3 = {0};
        assertArrayEquals(expected3, asc.ascendingMinimaShift(window, 0, minima));
    }

    @Test
    void testGetAscendingMinima(){
        int[] window1 = {8,9,5,3,6,5,1,1,0};
        int[] window2 = {7,4,8,6,3,4,2,1,2};
        int[] window3 = {1,2,3,4,5,6,7,8,9};
        int[] window4 = {9,8,7,6,5,4,3,2,1};
        int[] window5 = {9,1,1,3,4,2,6,8,9};
        
        int[] expected1 = {0};
        assertArrayEquals(expected1, asc.ascendingMinima(window1, window1.length));
        int[] expected2 = {1,2};
        assertArrayEquals(expected2, asc.ascendingMinima(window2, window2.length));
        int[] expected3 = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected3, asc.ascendingMinima(window3, window3.length));
        int[] expected4 = {1};
        assertArrayEquals(expected4, asc.ascendingMinima(window4, window4.length));
        int[] expected5 = {1,2,6,8,9};
        assertArrayEquals(expected5, asc.ascendingMinima(window5, window5.length));
    }

}