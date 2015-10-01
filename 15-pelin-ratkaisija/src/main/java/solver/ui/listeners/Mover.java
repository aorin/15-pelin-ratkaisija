package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Renderer;

public class Mover implements ActionListener {

    private Timer timer;
    private Renderer renderer;
    private Puzzle puzzle;
    private List<Move> moves;
    private int i;
    
    public Mover(Renderer renderer) {
        this.renderer = renderer;
    }

    public void move(Puzzle puzzle, List<Move> moves) {
        this.i = 0;
        this.puzzle = puzzle;
        this.moves = moves;

        this.timer = new Timer(300, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (i < moves.length()) {
            puzzle.move(moves.get(i));
            renderer.repaint();
            i++;
        } else {
            timer.stop();
        }
    }
}
