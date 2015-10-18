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
    public void updatesCorrectly1() {
        puzzle = new Puzzle(new int[][]{{7, 6, 1}, {8, 2, 5}, {3, 4, 0}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.LEFT);
        Point zero = puzzle.positionOfZero();
        assertEquals(-1, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX() + 1, zero.getY()));
    }

    @Test
    public void updatesCorrectly2() {
        puzzle = new Puzzle(new int[][]{{9, 0, 3, 2}, {11, 14, 10, 13}, {1, 4, 15, 8}, {7, 5, 12, 6}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.RIGHT);
        Point zero = puzzle.positionOfZero();
        assertEquals(-1, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX() - 1, zero.getY()));
    }

    @Test
    public void updatesCorrectly3() {
        puzzle = new Puzzle(new int[][]{{2, 8, 0, 11}, {4, 9, 6, 15}, {13, 1, 12, 5}, {7, 3, 10, 14}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.DOWN);
        Point zero = puzzle.positionOfZero();
        assertEquals(1, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX(), zero.getY() - 1));
    }

    @Test
    public void updatesCorrectly4() {
        puzzle = new Puzzle(new int[][]{{3, 5, 4}, {2, 8, 0}, {1, 6, 7}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.UP);
        Point zero = puzzle.positionOfZero();
        assertEquals(1, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX(), zero.getY() + 1));
    }

    @Test
    public void updatesCorrectly5() {
        puzzle = new Puzzle(new int[][]{{1, 5, 7}, {2, 6, 8}, {3, 0, 4}});
        calculator = new LinearConflicts(puzzle);
        puzzle.move(Move.DOWN);
        Point zero = puzzle.positionOfZero();
        assertEquals(2, calculator.changeBetweenStates(zero.getX(), zero.getY(), zero.getX(), zero.getY() - 1));
    }
}
