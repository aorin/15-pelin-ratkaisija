package solver.logic.algorithms.heuristic;

import solver.logic.domain.Puzzle;

/**
 * Luokka, joka tarjoaa toiminnallisuuden pelin lineaaristen konfliktien
 * laskemiseen.
 */
public class LinearConflicts {

    private int n;
    private int[][] values;
    private boolean[][] numberShouldBeInColumn;
    private boolean[][] numberShouldBeInRow;

    /**
     * Konstruktori luo uuden laskijan annetun pelin avulla.
     *
     * @param puzzle N-peli
     */
    public LinearConflicts(Puzzle puzzle) {
        this.n = puzzle.n();
        this.values = puzzle.values();
        this.numberShouldBeInColumn = new boolean[n][n * n];
        this.numberShouldBeInRow = new boolean[n][n * n];
        checkRows();
        checkColumns();
    }

    /**
     * Metodi palauttaa kaikki pelissä esiintyneet konfliktit.
     *
     * @return Lineaariset konfliktit
     */
    public int getConflicts() {
        return countAllConfilicts();
    }

    /**
     * Metodi kertoo lineaaristen konfliktien muutoksesta jonkun siirron
     * jälkeen.
     *
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     * @return Muutoksen arvo
     */
    public int changeBetweenStates(int x1, int y1, int x2, int y2) {
        int change = 0;
        int value = values[x2][y2];
        values[x1][y1] = value;

        if (x1 != x2) {
            change += columnConflicts(x1);
            change -= columnConflicts(x2);
            values[x1][y1] = 0;
            values[x2][y2] = 0;
            change -= columnConflicts(x1);
            change += columnConflicts(x2);
        } else if (y1 != y2) {
            change += rowConflicts(y1);
            change -= rowConflicts(y2);
            values[x1][y1] = 0;
            values[x2][y2] = 0;
            change -= rowConflicts(y1);
            change += rowConflicts(y2);
        }
        values[x2][y2] = value;

        return -change;
    }

    private int countAllConfilicts() {
        int conflicts = 0;

        for (int i = 0; i < n; i++) {
            conflicts += rowConflicts(i);
            conflicts += columnConflicts(i);
        }

        return conflicts;
    }

    private void checkRows() {
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n; i++) {
                for (int j = 1 + n * row; j < 1 + n * row + n; j++) {
                    if (j != n * n) {
                        numberShouldBeInRow[row][j] = true;
                    }
                }
            }
        }
    }

    private void checkColumns() {
        for (int col = 0; col < n; col++) {
            for (int i = 0; i < n; i++) {
                for (int j = 1 + col; j < n * n - 1 + col; j += n) {
                    if (j != n * n) {
                        numberShouldBeInColumn[col][j] = true;
                    }
                }
            }
        }

    }

    private int rowConflicts(int row) {
        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            if (numberShouldBeInRow[row][values[i][row]]) {
                positions[i] = values[i][row];
            }
        }

        int conflicts = countInversions(positions);
        return conflicts;
    }

    private int columnConflicts(int col) {
        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            if (numberShouldBeInColumn[col][values[col][i]]) {
                positions[i] = values[col][i];
            }
        }

        int conflicts = countInversions(positions);
        return conflicts;
    }

    private int countInversions(int[] array) {
        int inversions = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0 && array[j] < array[i]) {
                        inversions++;
                    }
                }
            }
        }

        return inversions;
    }
}
