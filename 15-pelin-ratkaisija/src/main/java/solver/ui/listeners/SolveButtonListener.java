package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.algorithms.IDAStar;
import solver.logic.algorithms.SolvabilityDeterminer;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Window;

public class SolveButtonListener implements ActionListener {

    private Puzzle puzzle;
    private SolvabilityDeterminer solvabilityDeterminer;
    private IDAStar idastar;
    private Window window;
    private Mover mover;
    private Thread thread;

    public SolveButtonListener(Window window, Puzzle puzzle) {
        this.puzzle = puzzle;
        this.window = window;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
        this.mover = new Mover(window);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        window.disableButtons();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean solvable = solvabilityDeterminer.puzzleIsSolvable(puzzle);

                if (!solvable) {
                    window.alert("Peliä ei ole mahdollista ratkaista.");
                    window.enableButtons();
                    return;
                }

                Puzzle copy = puzzle.copy();
                idastar = new IDAStar(copy);

                window.alert("Ratkaistaan peliä...");
                List<Move> moves = idastar.solve();
                if (moves == null) {
                    window.alert("Ratkaisua ei löytynyt! D:");
                } else {
                    window.addKeyListener(moves);
                    window.alert("Ratkaisu löytyi! Siirtojen määrä: " + moves.length());
                    window.enableButtons();
                }
            }
        });

        thread.start();
    }
}
