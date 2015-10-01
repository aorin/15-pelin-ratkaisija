package solver.logic.util;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.dataStructures.List;

public class GameboardGeneratorTest {

    private GameboardGenerator g;

    public GameboardGeneratorTest() {
        g = new GameboardGenerator();
    }

    @Test
    public void returns4x4Array() {
        int[][] array = g.generate4x4();
        assertTrue(array.length == 4 && array[0].length == 4);
    }

    @Test
    public void returns3x3Array() {
        int[][] array = g.generate3x3();
        assertTrue(array.length == 3 && array[0].length == 3);
    }

    @Test
    public void arrayContainsAllNumbers() {
        int[][] array = g.generate4x4();
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
        int[][] array1 = g.generate4x4();
        int[][] array2 = g.generate4x4();

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
