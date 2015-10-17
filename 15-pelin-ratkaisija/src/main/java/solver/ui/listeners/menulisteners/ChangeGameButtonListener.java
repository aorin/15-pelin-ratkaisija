package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

/**
 * Luokka kuuntelee nappia, jonka avulla voi vaihtaa erikokoisten pelin välillä.
 */
public class ChangeGameButtonListener implements ActionListener {
    private App app;
    private GameboardGenerator generator;
    private int n;

    public ChangeGameButtonListener(App app) {
        this.app = app;
        this.generator = app.getGenerator();
        this.n = app.getN();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Puzzle puzzle;
        if (n == 4) {
            puzzle = new Puzzle(generator.generate3x3());
        } else {
            puzzle = new Puzzle(generator.generate4x4());
        }
       
        app.changePuzzleAndSize(puzzle);
    }
}
