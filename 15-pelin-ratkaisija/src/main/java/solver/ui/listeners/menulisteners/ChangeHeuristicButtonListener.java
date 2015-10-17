package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.ui.Window;

/**
 * Luokka kuuntelee nappia "Vaihda Heuristiikkaa".
 */
public class ChangeHeuristicButtonListener implements ActionListener {
    private App app;
    private Window window;

    public ChangeHeuristicButtonListener(App app, Window window) {
        this.app = app;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        app.changeHeuristic();
        if (app.getHeuresticNro() == 0) {
            window.alert("ManhattanDistanceWithLinearConflicts käytössä");
        } else {
            window.alert("ManhattanDistance käytössä");
        }
    }
}