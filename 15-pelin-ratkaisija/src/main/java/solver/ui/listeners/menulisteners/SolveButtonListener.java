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

public class SolveButtonListener implements ActionListener {

    private App app;
    private Puzzle puzzle, copy;
    private SolvabilityDeterminer solvabilityDeterminer;
    private IDAStar idastar;
    private Window window;
    private Mover mover;
    private Thread thread;
    private int heuristicNro;
    private Heuristic heuristic;

    public SolveButtonListener(App app, Window window) {
        this.puzzle = app.getPuzzle();
        this.window = window;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
        this.mover = new Mover(window);
        this.heuristicNro = 0;
    }
    
    public void changeHeuristic() {
        if (heuristicNro == 0) {
            heuristicNro = 1;
            window.alert("ManhattanDistance käytössä");
        } else {
            heuristicNro = 0;
            window.alert("ManhattanDistanceWithLinearConflicts käytössä");
        }
    }
    
    public int getHeuristicNro() {
        return heuristicNro;
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
                boolean solvable = solvabilityDeterminer.puzzleIsSolvable(puzzle);

                if (!solvable) {
                    window.alert("Peliä ei ole mahdollista ratkaista.");
                    window.enableButtonsExceptMover();
                    return;
                }
                
                Puzzle copy = puzzle.copy();
                if (heuristicNro == 0) {
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
                    window.addKeyListener(moves);
                    window.alert("Siirtojen määrä: " + moves.length() + ", aika: " + (idastar.searchTime() / 1000000.0 / 1000) + " s");
                    window.enableButtonsExceptMover();
                }
            }
        });

        thread.start();
    }
}
