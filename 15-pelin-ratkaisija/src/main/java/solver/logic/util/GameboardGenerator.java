package solver.logic.util;

import solver.logic.dataStructures.List;
import java.util.Random;

/**
 * Luokka generoi uuden satunnaisen 15-pelin peliasetelman.
 */
public class GameboardGenerator {
    private Random random;

    public GameboardGenerator() {
        random = new Random();
    }

    /**
     * Luo uuden peliasetelman 15-pelille.
     *
     * @return 4 x 4 taulukko, johon on sijoittettu satunnaisesti luvut 0 - 15.
     */
    public int[][] generate4x4() {
        return generateNxN(4);
    }

    /**
     * Luo uuden peliasetelman 8-pelille.
     *
     * @return 3 x 3 taulukko, johon on sijoittettu satunnaisesti luvut 0 - 8.
     */
    public int[][] generate3x3() {
        return generateNxN(3);
    }

    private int[][] generateNxN(int n) {
        int[][] gameboard = new int[n][n];
        List used = new List();

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                int value = random.nextInt(n * n);
                while (used.contains(value)) {
                    value = random.nextInt(n * n);
                }
                gameboard[i][j] = value;
                used.add(value);
            }
        }
        
        return gameboard;
    }
}
