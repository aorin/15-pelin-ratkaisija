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
    public void valueOfNIsCorrect() {
        assertEquals(4, puzzle.n());
    }

    @Test
    public void movesTiles() {
        puzzle = new Puzzle(new int[][]{{0, 1}, {2, 3}});
        assertTrue(puzzle.move(1, 0));
        assertEquals(2, puzzle.valueAtPoint(0, 0));
        assertEquals(0, puzzle.valueAtPoint(1, 0));
    }
}
