package solver.logic.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;

public class IDAStarTest {

    private IDAStar idastar;

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
        idastar = new IDAStar(new Puzzle(new int[][]{{1, 5, 9, 14}, {2, 6, 10, 15}, {3, 7, 11, 13}, {4, 8, 12, 0}}));
        List<Move> moves = idastar.solve();
        
        Puzzle puzzle = new Puzzle(new int[][]{{1, 5, 9, 14}, {2, 6, 10, 15}, {3, 7, 11, 13}, {4, 8, 12, 0}});
        for (int i = 0; i < moves.length(); i++) {
            puzzle.move(moves.get(i));
        }
        
        boolean isInGoalState = true;
        int k = 1;
        for (int i = 0; i < puzzle.n(); i++) {
            for (int j = 0; j < puzzle.n(); j++) {
                if (puzzle.valueAtPoint(j, i) != k && k != 16) {
                    isInGoalState = false;
                } 
                k++;
            }
        }
        
        assertTrue(isInGoalState);
    }
}
