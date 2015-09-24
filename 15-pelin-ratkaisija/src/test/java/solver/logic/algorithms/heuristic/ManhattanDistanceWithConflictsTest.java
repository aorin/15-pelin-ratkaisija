package solver.logic.algorithms.heuristic;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

public class ManhattanDistanceWithConflictsTest {

    private ManhattanDistanceWithConflicts calculator;
    private Puzzle puzzle;

    @Test
    public void hasRightGoalPosition() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(0, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue1() {
        puzzle = new Puzzle(new int[][]{{15, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 1}, {4, 8, 0, 12}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(11, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue2() {
        puzzle = new Puzzle(new int[][]{{7, 6, 8}, {2, 0, 3}, {4, 5, 1}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(18, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue3() {
        puzzle = new Puzzle(new int[][]{{4, 8, 1}, {5, 2, 3}, {7, 0, 6}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(19, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue4() {
        puzzle = new Puzzle(new int[][]{{1, 13, 2, 14}, {10, 6, 9, 5}, {15, 3, 12, 0}, {4, 8, 7, 11}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(25, calculator.getEstimate());
    }

    @Test
    public void calculatesCorrectValue5() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 15, 14}, {3, 10, 11, 7}, {4, 8, 12, 0}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        assertEquals(8, calculator.getEstimate());
    }

    @Test
    public void updatesCorrectly() {
        puzzle = new Puzzle(new int[][]{{4, 8, 1}, {5, 2, 3}, {7, 0, 6}});
        calculator = new ManhattanDistanceWithConflicts(puzzle);
        int estimate = calculator.getEstimate();

        puzzle.move(Move.LEFT);
        Point zero = puzzle.positionOfZero();
        assertEquals(18, calculator.update(estimate, zero.getX(), zero.getY(), zero.getX() + 1, zero.getY()));
    }
}
