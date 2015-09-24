package solver.logic.algorithms.heuristic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

public class LinearConflictsTest {

    private LinearConflicts calculator;
    private Puzzle puzzle;

    @Test
    public void calculatesCorrectValue1() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 1}, {4, 8, 12, 0}});
        calculator = new LinearConflicts(puzzle);
        assertEquals(0, calculator.getConflicts());
    }

    @Test
    public void calculatesCorrectValue2() {
        puzzle = new Puzzle(new int[][]{{2, 4, 7}, {1, 5, 8}, {3, 6, 0}});
        calculator = new LinearConflicts(puzzle);
        assertEquals(1, calculator.getConflicts());
    }

    @Test
    public void calculatesCorrectValue3() {
        puzzle = new Puzzle(new int[][]{{2, 7, 4}, {1, 5, 8}, {3, 6, 0}});
        calculator = new LinearConflicts(puzzle);
        assertEquals(2, calculator.getConflicts());
    }

    @Test
    public void calculatesCorrectValue4() {
        puzzle = new Puzzle(new int[][]{{5, 3, 8}, {4, 1, 7}, {2, 6, 0}});
        calculator = new LinearConflicts(puzzle);
        assertEquals(1, calculator.getConflicts());
    }

    @Test
    public void calculatesCorrectValue5() {
        puzzle = new Puzzle(new int[][]{{7, 6, 1}, {8, 2, 5}, {3, 4, 0}});
        calculator = new LinearConflicts(puzzle);
        assertEquals(4, calculator.getConflicts());
    }

    @Test
    public void updatesCorrectly() {
        puzzle = new Puzzle(new int[][]{{7, 6, 1}, {8, 2, 5}, {3, 4, 0}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.LEFT);
        Point zero = puzzle.positionOfZero();
        assertEquals(-1, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX() + 1, zero.getY()));
    }
}
