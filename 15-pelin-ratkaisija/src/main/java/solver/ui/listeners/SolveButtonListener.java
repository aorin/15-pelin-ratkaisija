package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.algorithms.IDAStar;
import solver.logic.domain.State;

public class SolveButtonListener implements ActionListener {
    private State gameState;
    private IDAStar idastar;

    public SolveButtonListener(State state) {
        this.gameState = state;
        this.idastar = new IDAStar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        State solution = idastar.solve(gameState);
        if (solution == null) {
            System.out.print("Ei ratkaisua!");
        } else {
            System.out.println("Ratkaisu löytyi!");
        }
    }
}
