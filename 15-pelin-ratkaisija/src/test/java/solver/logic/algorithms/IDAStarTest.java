package solver.logic.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

public class IDAStarTest {

    private IDAStar idastar;
    private GameboardGenerator generator;
    private SolvabilityDeterminer determiner;

    public IDAStarTest() {
        this.generator = new GameboardGenerator();
        this.determiner = new SolvabilityDeterminer();
    }

    @Test
    public void rightNumberOfMoves() {
        idastar = new IDAStar(new Puzzle(new int[][]{{1, 4, 0}, {2, 5, 7}, {3, 6, 8}}));
        List<Move> moves = idastar.solve();
        assertEquals(2, moves.length());
    }

    @Test
    public void rightNumberOfMoves2() {
        idastar = new IDAStar(new Puzzle(new int[][]{{1, 13, 2, 14}, {10, 6, 9, 5}, {15, 3, 12, 0}, {4, 8, 7, 11}}));
        List<Move> moves = idastar.solve();
        assertEquals(35, moves.length());
    }

    @Test
    public void rightMoves() {
        idastar = new IDAStar(new Puzzle(new int[][]{{1, 4, 0}, {2, 5, 7}, {3, 6, 8}}));
        List<Move> moves = idastar.solve();
        assertEquals(Move.RIGHT, moves.get(0));
        assertEquals(Move.RIGHT, moves.get(1));
    }

    @Test
    public void rightMoves2() {
        Puzzle puzzle = new Puzzle(generator.generate3x3());
        while (!determiner.puzzeIsSolvable(puzzle)) {
            puzzle = new Puzzle(generator.generate3x3());
        }
        Puzzle copy = puzzle.copy();
        idastar = new IDAStar(puzzle);
        List<Move> moves = idastar.solve();
        
        for (int i = 0; i < moves.length(); i++) {
            copy.move(moves.get(i));
        }
        
        boolean isInGoalState = true;
        int k = 1;
        for (int i = 0; i < copy.n(); i++) {
            for (int j = 0; j < copy.n(); j++) {
                if (copy.valueAtPoint(j, i) != k && k != copy.n() * copy.n()) {
                    isInGoalState = false;
                } 
                k++;
            }
        }
        
        assertTrue(isInGoalState);
    }
}
