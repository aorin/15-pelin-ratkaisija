package solver.logic.efficiencyTests;

import solver.logic.domain.Puzzle;

public class ExamplePuzzles {
    private Puzzle[] p;

    public ExamplePuzzles() {
        p = new Puzzle[80];
        p[40] = new Puzzle(new int[][]{{2, 13, 3, 5}, {8, 14, 1, 9}, {7, 6, 11, 15}, {12, 4, 10, 0}});
        p[45] = new Puzzle(new int[][]{{12, 0, 2, 5}, {4, 1, 3, 14}, {10, 7, 9, 11}, {6, 8, 13, 15}});
        p[50] = new Puzzle(new int[][]{{14, 10, 7, 1}, {2, 6, 11, 8}, {0, 15, 5, 13}, {4, 3, 12, 9}});
        p[55] = new Puzzle(new int[][]{{12, 10, 13, 1}, {5, 14, 3, 6}, {4, 7, 8, 0}, {15, 11, 9, 2}});
        p[60] = new Puzzle(new int[][]{{15, 8, 14, 11}, {12, 5, 9, 2}, {7, 10, 3, 13}, {1, 4, 6, 0}});
    }
    
    public Puzzle getPuzzle(int i) {
        return p[i];
    }
}
