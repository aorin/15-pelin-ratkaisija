package solver.logic.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.dataStructures.List;

public class GameboardGeneratorTest {

    private GameboardGenerator g;

    @Before
    public void setUp() {
        g = new GameboardGenerator();
    }

    @Test
    public void returns4x4Array() {
        int[][] array = g.generate();
        assertTrue(array.length == 4 && array[0].length == 4);
    }

    @Test
    public void arrayContainsAllNumbers() {
        int[][] array = g.generate();
        List list = new List();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (!list.contains(array[i][j])) {
                    list.add(array[i][j]);
                }
            }
        }

        assertEquals(16, list.length());
    }

    @Test
    public void positionsOfNumbersDiffers() {
        int[][] array1 = g.generate();
        int[][] array2 = g.generate();

        boolean identical = true;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    identical = false;
                }
            }
        }
        
        assertTrue(!identical);
    }
}
