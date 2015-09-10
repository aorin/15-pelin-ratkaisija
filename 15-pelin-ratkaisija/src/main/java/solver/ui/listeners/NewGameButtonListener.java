package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.domain.State;
import solver.logic.util.GameboardGenerator;
import solver.ui.Window;

public class NewGameButtonListener implements ActionListener {
    private Window window;
    private GameboardGenerator generator;

    public NewGameButtonListener(Window window) {
        this.window = window;
        this.generator = new GameboardGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        window.update(new State(generator.generate()));
    }
}
