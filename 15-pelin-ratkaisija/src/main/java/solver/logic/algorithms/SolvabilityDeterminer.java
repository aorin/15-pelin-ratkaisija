package solver.logic.algorithms;

public class SolvabilityDeterminer {
    private int zerosRow;

    public boolean puzzeIsSolvable(int[][] puzzle) {
        int[] array = copyValuesToOneDimensionalArray(puzzle);
        int inversions = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                inversions += getInversions(array, i);
            }
        }

        return (puzzle.length % 2 == 1 && inversions % 2 == 0) || (puzzle.length % 2 == 0 && ((inversions % 2 == 0) == (zerosRow % 2 == 1)));
    }

    private int[] copyValuesToOneDimensionalArray(int[][] values) {
        int[] array = new int[values.length * values.length];
        int k = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (values[j][i] == 0) {
                    zerosRow = i;
                }
                array[k] = values[j][i];
                k++;
            }
        }

        return array;
    }

    private int getInversions(int[] array, int i) {
        int inversions = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[i] && array[j] != 0) {
                inversions++;
            }
        }
        return inversions;
    }
}
