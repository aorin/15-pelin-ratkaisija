package solver.logic.domain;

import solver.logic.dataStructures.List;

/**
 * Luokka, joka määrittelee pelitilan.
 * <p>
 * Pelitilaan liittyviä ominaisuuksia ovat numeroiden sijainnit pelilaudalla,
 * edeltävä tila ja se, kuinka monta siirtoa kyseiseen tilaan pääsemiseksi
 * vaati.
 */
public class State {

    private int[][] values;
    private State previousState;
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

    /**
     * Metodi luo listan niistä tiloista, joihin on mahdollista päästä
     * kyseisestä tilasta.
     *
     * @return Lista seuraavista mahdollisista tiloista
     */
    public List<State> nextStates() {
        List<State> states = new List<>();

        int[] positionOfZero = positionOfZero();
        int x = positionOfZero[0], y = positionOfZero[1];

        if (x - 1 >= 0) {
            int[][] copy = copyArray(values);
            copy[x][y] = copy[x - 1][y];
            copy[x - 1][y] = 0;
            states.add(new State(copy));
        }

        if (x + 1 < values.length) {
            int[][] copy = copyArray(values);
            copy[x][y] = copy[x + 1][y];
            copy[x + 1][y] = 0;
            states.add(new State(copy));
        }

        if (y - 1 >= 0) {
            int[][] copy = copyArray(values);
            copy[x][y] = copy[x][y - 1];
            copy[x][y - 1] = 0;
            states.add(new State(copy));
        }

        if (y + 1 < values[0].length) {
            int[][] copy = copyArray(values);
            copy[x][y] = copy[x][y + 1];
            copy[x][y + 1] = 0;
            states.add(new State(copy));
        }

        return states;
    }

    public void setPrevious(State previous) {
        this.previousState = previous;
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

    private int[][] copyArray(int[][] array) {
        int[][] copy = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }
}
