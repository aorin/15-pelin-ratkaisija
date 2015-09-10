package solver.logic.domain;

import solver.logic.dataStructures.List;

/**
 * Luokka, joka määrittelee pelitilan.
 * <p>
 * Pelitilaan liittyviä ominaisuuksia ovat numeroiden sijainnit pelilaudalla
 * ja se, kuinka monta siirtoa kyseiseen tilaan pääsemiseksi vaati.
 */
public class State {
    private int[][] values;
    private List moves;
    private int cost;

    public State(int[][] values) {
        this.values = values;
    }

    public int valueAtPoint(int x, int y) {
        return this.values[x][y];
    }

    public int[][] values() {
        return this.values;
    }

    public boolean move(int dx, int dy) {
        int[] positionOfZero = positionOfZero();
        int x0 = positionOfZero[0], y0 = positionOfZero[1];

        try {
            values[x0][y0] = values[x0 + dx][y0 + dy];
            values[x0 + dx][y0 + dy] = 0;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        State obj = (State) o;
        int[][] array1 = this.values, array2 = obj.values;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return array1.length == array2.length;
    }

    private int[] positionOfZero() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
