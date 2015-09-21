package solver.logic.algorithms;

import solver.logic.algorithms.heuristic.ManhattanDistance;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.Puzzle;

public class ManhattanDistanceTest {
    private ManhattanDistance calculator;
    private Puzzle puzzle;
    
    @Before
    public void setUp() {
//        puzzle = new Puzzle(new int[][]{{1}, {2}});
//        calculator = new ManhattanDistance(puzzle);
    }
    
    @Test
    public void haveRightGoalPosition() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(0, calculator.getEstimate());
    }
    
    @Test
    public void calculatesCorrectValue() {
        puzzle = new Puzzle(new int[][]{{15, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 1}, {4, 8, 0, 12}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(11, calculator.getEstimate());
    }
}
