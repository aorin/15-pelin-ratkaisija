package solver.ui.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import solver.App;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

/**
 * Luokka tulkitsee käyttäjän näppäimistöllä antamia komentoja.
 */
public class KeyListener implements KeyEventDispatcher {
    
    private App app;
    private Window window;
    private Puzzle puzzle;
    private List<Move> moves;
    private boolean enabled;

    /**
     * Konstruktori luo uuden näppäimistönkuuntelijan annetun ohjelman ja ikkunan avulla.
     * 
     * @param app Käytössä oleva ohjelma
     * @param window Käytössä oleva käyttäliittymä-ikkuna
     */
    public KeyListener(App app, Window window) {
        this.app = app;
        this.window = window;
        this.puzzle = app.getPuzzle();
        this.enabled = true;
    }
    
    /**
     * Metodi laittaa näppäimistönkuuntelijan päälle tai pois päältä.
     * 
     * @param enabled Totuusarvo siitä, pidetäänkö kuuntelija päällä
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
        moves = app.getMoves();
        if (enabled && ke.getID() == KeyEvent.KEY_RELEASED) {
            if (moves == null) {
                return false;
            }

            //left and right arrow
            if (ke.getKeyCode() == 37) {
                if (moves.getI() > 0) {
                    puzzle.move(moves.get(moves.getI() - 1).getOpposite());
                    moves.setI(moves.getI() - 1);;
                }
            } else if (ke.getKeyCode() == 39) {
                if (moves.getI() < moves.length()) {
                    puzzle.move(moves.get(moves.getI()));
                    moves.setI(moves.getI() + 1);
                }
            }
            window.getRenderer().repaint();
        }
        return false;
    }
}