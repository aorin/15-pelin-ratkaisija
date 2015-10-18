package solver.logic.efficiencyTests;

import solver.logic.domain.Puzzle;

public class ExamplePuzzles {
    private Puzzle[] p15, p8;

    public ExamplePuzzles() {
        p15 = new Puzzle[80];
        p15[40] = new Puzzle(new int[][]{{2, 13, 3, 5}, {8, 14, 1, 9}, {7, 6, 11, 15}, {12, 4, 10, 0}});
        p15[45] = new Puzzle(new int[][]{{12, 0, 2, 5}, {4, 1, 3, 14}, {10, 7, 9, 11}, {6, 8, 13, 15}});
        p15[50] = new Puzzle(new int[][]{{14, 10, 7, 1}, {2, 6, 11, 8}, {0, 15, 5, 13}, {4, 3, 12, 9}});
        p15[55] = new Puzzle(new int[][]{{12, 10, 13, 1}, {5, 14, 3, 6}, {4, 7, 8, 0}, {15, 11, 9, 2}});
        p15[60] = new Puzzle(new int[][]{{15, 8, 14, 11}, {12, 5, 9, 2}, {7, 10, 3, 13}, {1, 4, 6, 0}});
        
        p8 = new Puzzle[30];
        p8[16] = new Puzzle(new int[][]{{0, 1, 5}, {2, 3, 7}, {6, 8, 4}});
        p8[18] = new Puzzle(new int[][]{{1, 8, 4}, {3, 0, 5}, {7, 6, 2}});
        p8[20] = new Puzzle(new int[][]{{5, 1, 4}, {6, 3, 8}, {2, 7, 0}});
        p8[22] = new Puzzle(new int[][]{{0, 2, 8}, {6, 7, 5}, {1, 4, 3}});
        p8[24] = new Puzzle(new int[][]{{0, 5, 1}, {8, 2, 7}, {6, 4, 3}});
        p8[26] = new Puzzle(new int[][]{{6, 4, 3}, {8, 7, 2}, {5, 1, 0}});
    }
    
    public Puzzle get15Puzzle(int i) {
        return p15[i];
    }
    
    public Puzzle get8Puzzle(int i) {
        return p8[i];
    }
}
