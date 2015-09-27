package solver;

import solver.logic.util.GameboardGenerator;
import solver.logic.domain.Puzzle;
import solver.ui.Window;
import javax.swing.SwingUtilities;

/**
 * Luokka, josta käynnistetään ohjelma 15-pelin ratkaisija.
 */
public class Main {
    public static void main(String[] args) {
        GameboardGenerator generator = new GameboardGenerator();
        
        //Puzzle puzzle = new Puzzle(new int[][]{{1, 5, 9, 14}, {2, 6, 10, 15}, {3, 7, 11, 13}, {4, 8, 12, 0}});
        Puzzle puzzle = new Puzzle(generator.generate4x4());
        Window window = new Window(puzzle, generator);
        SwingUtilities.invokeLater(window);
    }
}