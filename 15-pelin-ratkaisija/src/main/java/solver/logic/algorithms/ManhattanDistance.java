package solver.logic.algorithms;

import solver.logic.domain.Puzzle;
import solver.logic.dataStructures.Map;

/**
 * Luokka sisältää toiminnallisuuden tilan Manhattan-etäisyyden laskemiseen.
 */
public class ManhattanDistance {
    private Map<Integer, Integer[]> goalPositions;
    private int[][] values;
    private int previousEstimate;

    /**
     * Konstruktori luo uuden Manhattan-etäisyys-laskijan annetun peliasetelman
     * perusteella.
     * @param puzzle Käytössä oleva peliasetelma
     */
    public ManhattanDistance(Puzzle puzzle) {
        int n = puzzle.n();
        goalPositions = new Map<>();

        int j = 0, k = 0;
        for (int i = 1; i < n * n; i++) {
            Integer[] t = {j, k};
            goalPositions.put(i, t);
            j++;
            if (j >= n) {
                j = 0;
                k++;
            }
        }

        values = puzzle.values();
        previousEstimate = getDistance();
    }

    /**
     * Palauttaa asetelman Manhattan-etäisyyden.
     * @return Peliasetelman Manhattan-etäisyys
     */
    public int getEstimate() {
        return this.previousEstimate;
    }

    /**
     * Päivittää asetelman Manhattan-etäisyyden vastaamaan uutta tilannetta
     * jonkun palan siirron jälkeen.
     * 
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     */
    public void update(int x1, int y1, int x2, int y2) {
        Integer[] goalPos = goalPositions.get(values[x2][y2]);
        previousEstimate -= abs(x1 - goalPos[0]) + abs(y1 - goalPos[1]);
        previousEstimate += abs(x2 - goalPos[0]) + abs(y2 - goalPos[1]);
    }

    private int getDistance() {
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] != 0) {
                    Integer[] goalPos = goalPositions.get(values[i][j]);
                    sum += abs(i - goalPos[0]) + abs(j - goalPos[1]);
                }
            }
        }

        return sum;
    }

    private int abs(int number) {
        if (number < 0) {
            return -1 * number;
        }
        return number;
    }
}
