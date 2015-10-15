package solver.ui.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

public class KeyListener implements KeyEventDispatcher {

    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;
    private int i;
    private boolean enabled;

    public KeyListener(Window window, Puzzle puzzle, List<Move> moves) {
        this.window = window;
        this.puzzle = puzzle;
        this.moves = moves;
        this.i = 0;
        this.enabled = true;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
        if (enabled && ke.getID() == KeyEvent.KEY_RELEASED) {
            if (moves == null) {
                return false;
            }

            //left and right arrow
            if (ke.getKeyCode() == 37) {
                if (i > 0) {
                    puzzle.move(moves.get(i - 1).getOpposite());
                    i--;
                }
            } else if (ke.getKeyCode() == 39) {
                if (i < moves.length()) {
                    puzzle.move(moves.get(i));
                    i++;
                }
            }
            window.getRenderer().repaint();
        }
        return false;
    }
}
