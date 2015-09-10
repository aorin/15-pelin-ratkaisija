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
        GameboardGenerator generator = new GameboardGenerator();
        State state = new State(generator.generate());
        
        Window window = new Window(state);
        SwingUtilities.invokeLater(window);
    }
}