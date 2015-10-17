package solver.logic.algorithms.heuristic;

import solver.logic.domain.Puzzle;
import solver.logic.domain.Point;

/**
 * Luokka sisältää toiminnallisuuden tilan Manhattan-etäisyyden laskemiseen.
 */
public class ManhattanDistance implements Heuristic {

    private Point[] goalPositions;
    private int[][] values;

    /**
     * Konstruktori luo uuden Manhattan-etäisyys-laskijan annetun peliasetelman
     * perusteella.
     *
     * @param puzzle Käytössä oleva peliasetelma
     */
    public ManhattanDistance(Puzzle puzzle) {
        int n = puzzle.n();
        goalPositions = new Point[n * n];

        int j = 0, k = 0;
        for (int i = 1; i < n * n; i++) {
            goalPositions[i] = new Point(j, k);
            j++;
            if (j >= n) {
                j = 0;
                k++;
            }
        }

        values = puzzle.values();
    }

    /**
     * Palauttaa asetelman Manhattan-etäisyyden.
     *
     * @return Peliasetelman Manhattan-etäisyys
     */
    @Override
    public int getEstimate() {
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] != 0) {
                    Point goalPos = goalPositions[values[i][j]];
                    sum += abs(i - goalPos.getX()) + abs(j - goalPos.getY());
                }
            }
        }

        return sum;
    }

    /**
     * Päivittää asetelman Manhattan-etäisyyden vastaamaan uutta tilannetta
     * jonkun palan siirron jälkeen.
     *
     * @param estimate Edellisen asetelman Manhattan-etäisyys
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     * @return Uusi arvio etäisyydestä
     */
    @Override
    public int update(int estimate, int x1, int y1, int x2, int y2) {
        Point goalPos = goalPositions[values[x2][y2]];
        estimate -= abs(x1 - goalPos.getX()) + abs(y1 - goalPos.getY());
        estimate += abs(x2 - goalPos.getX()) + abs(y2 - goalPos.getY());
        return estimate;
    }

    private int abs(int number) {
        if (number < 0) {
            return -1 * number;
        }
        return number;
    }
}
