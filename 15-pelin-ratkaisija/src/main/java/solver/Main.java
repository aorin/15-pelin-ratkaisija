package solver;

import solver.logic.util.GameboardGenerator;
import solver.logic.domain.State;
import solver.ui.Window;
import javax.swing.SwingUtilities;

/**
 * Luokka, josta käynnistetään ohjelma 15-pelin ratkaisija.
 */
public class Main {
    public static void main(String[] args) {
//        GameboardGenerator generator = new GameboardGenerator();
//        State state = new State(generator.generate());
        State state = new State(new int[][]{{15, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 1}, {4, 8, 0, 12}});
        
        Window window = new Window(state);
        SwingUtilities.invokeLater(window);
    }
}