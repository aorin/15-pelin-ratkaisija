package solver.logic.algorithms;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolvabilityDeterminerTest {
    private SolvabilityDeterminer d;

    public SolvabilityDeterminerTest() {
        d = new SolvabilityDeterminer();
    }

    @Test
    public void solvablePuzzle1() {
        int[][] puzzle = new int[][]{{12, 7, 5, 8}, {1, 11, 0, 13}, {10, 4, 9, 6}, {2, 14, 15, 3}};
        assertTrue(d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void solvablePuzzle2() {
        int[][] puzzle = new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}};
        assertTrue(d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void unsolvablePuzzle1() {
        int[][] puzzle = new int[][]{{1, 5, 9, 13}, {2, 6, 10, 15}, {3, 7, 11, 14}, {4, 8, 12, 0}};
        assertTrue(!d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void unsolvablePuzzle2() {
        int[][] puzzle = new int[][]{{13, 10, 14, 15}, {9, 0, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}};
        assertTrue(!d.puzzeIsSolvable(puzzle));
    }
}
