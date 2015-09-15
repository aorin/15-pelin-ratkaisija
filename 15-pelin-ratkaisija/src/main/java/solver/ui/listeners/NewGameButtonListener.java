package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.Window;

public class NewGameButtonListener implements ActionListener {

    private Window window;
    private GameboardGenerator generator;
    private int n;

    public NewGameButtonListener(Window window, GameboardGenerator generator, int n) {
        this.window = window;
        this.generator = generator;
        this.n = n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (n == 3) {
            window.update(new Puzzle(generator.generate3x3()));
        } else {
            window.update(new Puzzle(generator.generate4x4()));
        }

    }
}
