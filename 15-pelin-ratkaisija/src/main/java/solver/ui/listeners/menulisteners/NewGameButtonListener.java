package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

/**
 * Luokka kuuntelee nappia "Uusi".
 */
public class NewGameButtonListener implements ActionListener {
    private App app;
    private GameboardGenerator generator;
    private int n;

    public NewGameButtonListener(App app) {
        this.app = app;
        this.generator = app.getGenerator();
        this.n = app.getN();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (n == 3) {
            app.changePuzzle(new Puzzle(generator.generate3x3()));
        } else {
            app.changePuzzle(new Puzzle(generator.generate4x4()));
        }
    }
}