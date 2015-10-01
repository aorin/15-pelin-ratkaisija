package solver.logic.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.Puzzle;

public class SolvabilityDeterminerTest {

    private SolvabilityDeterminer d;

    public SolvabilityDeterminerTest() {
        d = new SolvabilityDeterminer();
    }

    @Test
    public void solvablePuzzle1() {
        Puzzle puzzle = new Puzzle(new int[][]{{12, 7, 5, 8}, {1, 11, 0, 13}, {10, 4, 9, 6}, {2, 14, 15, 3}});
        assertTrue(d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void solvablePuzzle2() {
        Puzzle puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}});
        assertTrue(d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void solvablePuzzle3() {
        Puzzle puzzle = new Puzzle(new int[][]{{4, 0, 6}, {7, 5, 2}, {3, 8, 1}});
        assertTrue(d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void unsolvablePuzzle1() {
        Puzzle puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 15}, {3, 7, 11, 14}, {4, 8, 12, 0}});
        assertTrue(!d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void unsolvablePuzzle2() {
        Puzzle puzzle = new Puzzle(new int[][]{{13, 10, 14, 15}, {9, 0, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}});
        assertTrue(!d.puzzeIsSolvable(puzzle));
    }

    @Test
    public void unsolvablePuzzle3() {
        Puzzle puzzle = new Puzzle(new int[][]{{8, 4, 2}, {3, 1, 7}, {5, 6, 0}});
        assertTrue(!d.puzzeIsSolvable(puzzle));
    }
}
