package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeHeuristicButtonListener implements ActionListener {
    private SolveButtonListener solver;

    public ChangeHeuristicButtonListener(SolveButtonListener solver) {
        this.solver = solver;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        solver.changeHeuristic();
    }
}
