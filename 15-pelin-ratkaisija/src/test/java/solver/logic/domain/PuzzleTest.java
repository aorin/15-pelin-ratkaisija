package solver.logic.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.util.GameboardGenerator;

public class PuzzleTest {

    private GameboardGenerator generator;
    private Puzzle puzzle;

    public PuzzleTest() {
        this.generator = new GameboardGenerator();
    }

    @Before
    public void setUp() {
        puzzle = new Puzzle(generator.generate4x4());
    }

    @Test
    public void returnsCorrectValueAtPoint() {
        puzzle = new Puzzle(new int[][]{{0, 1}, {2, 3}});
        assertEquals(1, puzzle.valueAtPoint(0, 1));
    }

    @Test
    public void returnsAllValues() {
        int[][] values = puzzle.values();
        assertEquals(4, values.length);
    }

    @Test
    public void positionOfZeroIsCorrect() {
        Point posOfZero = puzzle.positionOfZero();
        assertEquals(0, puzzle.valueAtPoint(posOfZero.getX(), posOfZero.getY()));
    }

    @Test
    public void positionOfZeroIsCorrect2() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 0}});
        Point posOfZero = puzzle.positionOfZero();
        assertEquals(3, posOfZero.getX());
        assertEquals(3, posOfZero.getY());
    }
    
        @Test
    public void positionOfZeroIsCorrect3() {
        puzzle = new Puzzle(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}});
        Point posOfZero = puzzle.positionOfZero();
        assertEquals(null, posOfZero);
    }

    @Test
    public void valueOfNIsCorrect() {
        assertEquals(4, puzzle.n());
    }

    @Test
    public void copiesPuzzle() {
        int[][] values = puzzle.values();
        int[][] copy = puzzle.copy().values();
        boolean samePuzzle = true;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (values[i][j] != copy[i][j]) {
                    samePuzzle = false;
                }
            }
        }

        assertTrue(samePuzzle);
    }

    @Test
    public void costIs0AtTheBeginning() {
        assertEquals(0, puzzle.getCost());
    }

    @Test
    public void canSetCost() {
        puzzle.setCost(10);
        assertEquals(10, puzzle.getCost());
    }

    @Test
    public void movesTiles() {
        puzzle = new Puzzle(new int[][]{{0, 1}, {2, 3}});
        assertTrue(puzzle.canMove(Move.RIGHT));
        puzzle.move(Move.RIGHT);
        assertEquals(2, puzzle.valueAtPoint(0, 0));
        assertEquals(0, puzzle.valueAtPoint(1, 0));
    }
}
