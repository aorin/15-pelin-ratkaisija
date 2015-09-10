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
 * Luo uuden peliasetelman.
 * 
 * @return Kaksiuloitteinen 4 x 4 taulukko, johon on sijoittettu satunnaisesti
 * luvut 0 - 16.
 */   
    public int[][] generate() {
        int[][] gameboard = new int[4][4];
        List used = new List();
        
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                int value = random.nextInt(16);
                while (used.contains(value)) {
                    value = random.nextInt(16);
                }
                gameboard[i][j] = value;
                used.add(value);
            }
        }
        
        return gameboard;
    }
}
