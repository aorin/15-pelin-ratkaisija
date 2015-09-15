package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.Window;

public class ChangeGameButtonListener implements ActionListener {
    private Window window;
    private GameboardGenerator generator;
    private int n;
    
    public ChangeGameButtonListener(Window window, GameboardGenerator generator, int n) {
        this.window = window;
        this.generator = generator;
        this.n = n;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Puzzle puzzle;
        if (n == 4) {
            puzzle = new Puzzle(generator.generate3x3());
        } else {
            puzzle = new Puzzle(generator.generate4x4());
        }
       
        window.update(puzzle);
    }
}
