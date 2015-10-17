package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.logic.domain.Puzzle;
import solver.ui.Window;
import solver.ui.listeners.Mover;

/**
 * Luokka kuuntelee nappia "Siirtäjä".
 */
public class MoverButtonListener implements ActionListener {

    private Mover mover;
    private App app;
    private Window window;
    private Puzzle puzzle;

    public MoverButtonListener(App app, Window window) {
        this.app = app;
        this.mover = new Mover(window);
        this.window = window;
        this.puzzle = app.getPuzzle();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (app.getMoves() != null) {
            window.disableButtons();

            mover.move(puzzle, app.getMoves());
        }
    }
}