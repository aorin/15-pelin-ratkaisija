package solver.logic.algorithms.heuristic;

import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

/**
 *
 */
public class LinearConflicts {

    private int n;
    private int[][] values;
    private int[] rowConflicts;
    private int[] colConflicts;

    public LinearConflicts(Puzzle puzzle) {
        this.n = puzzle.n();
        this.values = puzzle.values();
        this.rowConflicts = new int[n];
        this.colConflicts = new int[n];
    }

    public int getConflicts() {
        return countAllConfilicts();
    }

    /**
     * Päivittää asetelman vastaamaan uutta tilannetta jonkun palan siirron
     * jälkeen.
     *
     * @param estimate
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     */
    public int update(int estimate, int x1, int y1, int x2, int y2) {
        if (x1 != x2) {
            estimate -= colConflicts[y1];
            estimate += columnConflicts(y2);
        } else {
            estimate -= rowConflicts[x1];
            estimate += rowConflicts(x2);
        }
        return estimate;
    }

    private int countAllConfilicts() {
        int conflicts = 0;

        for (int i = 0; i < n; i++) {
            conflicts += rowConflicts(i);
            conflicts += columnConflicts(i);
        }

        return conflicts;
    }

    private int rowConflicts(int row) {
        int[] positions = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1 + n * row; j < 1 + n * row + n; j++) {
                if (values[i][row] == j) {
                    positions[j - n * row] = i + 1;
                }
            }
        }

        int conflicts = countConflicts(positions);
        this.rowConflicts[row] = conflicts;
        return conflicts;
    }

    private int columnConflicts(int col) {
        int[] positions = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1 + col, k = 1; j < n * n - 1 + col; j += n, k++) {
                if (values[col][i] == j) {
                    positions[k] = i + 1;
                }
            }
        }

        int conflicts = countConflicts(positions);
        this.colConflicts[col] = conflicts;
        return conflicts;
    }

    private int countConflicts(int[] array) {
        int conflicts = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0 && array[j] < array[i]) {
                        conflicts++;
                    }
                }
            }
        }

        return conflicts;
    }
}
