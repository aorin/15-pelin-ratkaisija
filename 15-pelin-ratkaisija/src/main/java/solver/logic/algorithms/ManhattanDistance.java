package solver.logic.algorithms;

import solver.logic.domain.State;
import solver.logic.dataStructures.Map;

/**
 * Luokka sisältää toiminnallisuuden tilan Manhattan-etäisyyden laskemiseen.
 */
public class ManhattanDistance {

    private Map<Integer, Integer[]> goalPositions;

    public ManhattanDistance() {
        goalPositions = new Map<>();

        int j = 0, k = 0;
        for (int i = 1; i < 16; i++) {
            Integer[] t = {j, k};
            goalPositions.put(i, t);
            j++;
            if (j > 3) {
                j = 0;
                k++;
            }
        }
        goalPositions.put(0, new Integer[]{j, k});
    }

    /**
     * Metodi laskee ja palauttaa tilan Manhattan-etäisyyden.
     *
     * @return tilan Manhattan-etäisyys
     */
    public int getDistance(State state) {
        int sum = 0;
        int[][] values = state.values();

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
