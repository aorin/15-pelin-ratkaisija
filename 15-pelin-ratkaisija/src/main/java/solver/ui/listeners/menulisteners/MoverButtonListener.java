package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;
import solver.ui.listeners.Mover;

public class MoverButtonListener implements ActionListener {

    private Mover mover;
    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;

    public MoverButtonListener(App app, Window window) {
        this.mover = new Mover(window);
        this.window = window;
        this.puzzle = app.getPuzzle();
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
