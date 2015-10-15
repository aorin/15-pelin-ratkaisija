package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

public class Mover implements ActionListener {

    private Timer timer;
    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;
    private int i;

    public Mover(Window window) {
        this.window = window;
    }

    public void move(Puzzle puzzle, List<Move> moves, int i) {
        this.i = i;
        this.puzzle = puzzle;
        this.moves = moves;

        this.timer = new Timer(300, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (i < moves.length()) {
            puzzle.move(moves.get(i));
            window.getRenderer().repaint();
            i++;
        } else {
            timer.stop();
            window.getKeyListener().setI(i);
            window.enableAllButtons();
            window.getKeyListener().setEnabled(true);
        }
    }
}
