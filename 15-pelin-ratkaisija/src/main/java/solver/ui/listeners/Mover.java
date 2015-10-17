package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

/**
 * Luokka sisältää toiminnallisuuden palojen automaattisiirtämiseen.
 */
public class Mover implements ActionListener {

    private Timer timer;
    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;

    /**
     * Konstruktori luo uuden siirtäjän
     * 
     * @param window Käytössä oleva ikkuna
     */
    public Mover(Window window) {
        this.window = window;
    }

    /**
     * Metodi aloittaa palojen siirtämisen.
     * 
     * @param puzzle Peli
     * @param moves Siirrot
     */
    public void move(Puzzle puzzle, List<Move> moves) {
        this.puzzle = puzzle;
        this.moves = moves;
        window.getKeyListener().setEnabled(false);

        this.timer = new Timer(300, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (moves.getI() < moves.length()) {
            puzzle.move(moves.get(moves.getI()));
            window.getRenderer().repaint();
            moves.setI(moves.getI() + 1);
        } else {
            timer.stop();
            window.enableButtons();
            window.getKeyListener().setEnabled(true);
        }
    }
}
