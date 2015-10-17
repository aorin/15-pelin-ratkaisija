package solver.ui.listeners.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.App;
import solver.logic.algorithms.IDAStar;
import solver.logic.algorithms.SolvabilityDeterminer;
import solver.logic.algorithms.heuristic.Heuristic;
import solver.logic.algorithms.heuristic.ManhattanDistance;
import solver.logic.algorithms.heuristic.ManhattanDistanceWithConflicts;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;
import solver.ui.listeners.Mover;

/**
 * Luokka kuuntelee nappia "Ratkaise".
 */
public class SolveButtonListener implements ActionListener {

    private App app;
    private Puzzle puzzle;
    private SolvabilityDeterminer solvabilityDeterminer;
    private IDAStar idastar;
    private Window window;
    private Mover mover;
    private Heuristic heuristic;

    public SolveButtonListener(App app, Window window) {
        this.app = app;
        this.puzzle = app.getPuzzle();
        this.window = window;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
        this.mover = new Mover(window);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        window.disableButtons();
        if (window.getKeyListener() != null) {
            window.getKeyListener().setEnabled(false);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!solvabilityDeterminer.puzzleIsSolvable(puzzle)) {
                    window.alert("Peliä ei ole mahdollista ratkaista.");
                    window.enableButtons();
                    window.disableButton(2);
                    return;
                }

                Puzzle copy = puzzle.copy();
                if (app.getHeuresticNro() == 0) {
                    heuristic = new ManhattanDistanceWithConflicts(copy);
                } else {
                    heuristic = new ManhattanDistance(copy);
                }
                idastar = new IDAStar(copy, heuristic);

                window.alert("Ratkaistaan peliä...");
                List<Move> moves = idastar.solve();
                if (moves == null) {
                    window.alert("Ratkaisua ei löytynyt! D:");
                } else {
                    app.setMoves(moves);
                    window.addKeyListener();
                    window.alert("Siirtojen määrä: " + moves.length() + ", aika: " + (idastar.searchTime() / 1000000.0 / 1000) + " s");
                    window.enableButtons();
                }
            }
        });

        thread.start();
    }
}
