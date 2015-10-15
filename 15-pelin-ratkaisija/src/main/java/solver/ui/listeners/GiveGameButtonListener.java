package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import solver.logic.domain.Puzzle;
import solver.ui.SmallWindow;

public class GiveGameButtonListener implements ActionListener {
    private Puzzle puzzle;
    
    public GiveGameButtonListener(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        SwingUtilities.invokeLater(new SmallWindow(puzzle.n()));
    }
}
