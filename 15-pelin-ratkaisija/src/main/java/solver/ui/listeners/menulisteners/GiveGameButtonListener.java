package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.ui.Window;

/**
 * Luokka kuuntelee nappia "Syötä uusi".
 */
public class GiveGameButtonListener implements ActionListener {
    private Window window;
    
    public GiveGameButtonListener(Window window) {
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        window.changeToInputMode();
    }
}