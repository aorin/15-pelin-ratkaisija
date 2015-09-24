package solver.logic.algorithms.heuristic;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

public class ManhattanDistanceTest {

    private ManhattanDistance calculator;
    private Puzzle puzzle;

    @Test
    public void hasRightGoalPosition() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(0, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue1() {
        puzzle = new Puzzle(new int[][]{{15, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 1}, {4, 8, 0, 12}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(11, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue2() {
        puzzle = new Puzzle(new int[][]{{7, 5, 8}, {2, 0, 3}, {4, 6, 1}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(14, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue3() {
        puzzle = new Puzzle(new int[][]{{5, 8, 1}, {2, 4, 3}, {7, 0, 6}});
        calculator = new ManhattanDistance(puzzle);
        assertEquals(15, calculator.getEstimate());
    }

    @Test
    public void updatesCorrectly() {
        puzzle = new Puzzle(new int[][]{{5, 8, 1}, {2, 4, 3}, {7, 0, 6}});
        calculator = new ManhattanDistance(puzzle);
        int estimate = calculator.getEstimate();
        
        puzzle.move(Move.DOWN);
        Point zero = puzzle.positionOfZero();
        assertEquals(14, calculator.update(estimate, zero.getX(), zero.getY(), zero.getX(), zero.getY() - 1));
    }
}
