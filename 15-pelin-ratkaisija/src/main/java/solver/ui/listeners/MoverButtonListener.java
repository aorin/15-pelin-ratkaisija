package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

public class MoverButtonListener implements ActionListener {

    private Mover mover;
    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;

    public MoverButtonListener(Window window, Puzzle puzzle) {
        this.mover = new Mover(window);
        this.window = window;
        this.puzzle = puzzle;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (moves != null) {
            window.disableButtons();
            window.getKeyListener().setEnabled(false);
            mover.move(puzzle, moves, window.getKeyListener().getI());
        }
    }
}
