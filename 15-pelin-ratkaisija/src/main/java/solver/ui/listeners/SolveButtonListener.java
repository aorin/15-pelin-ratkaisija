package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.algorithms.IDAStar;
import solver.logic.algorithms.SolvabilityDeterminer;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.Renderer;

public class SolveButtonListener implements ActionListener {

    private Puzzle puzzle;
    private SolvabilityDeterminer solvabilityDeterminer;
    private IDAStar idastar;
    private Renderer renderer;

    public SolveButtonListener(Puzzle puzzle, Renderer renderer) {
        this.puzzle = puzzle;
        this.renderer = renderer;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.idastar = new IDAStar(puzzle);
        System.out.println("Tarkistetaan, onko peli ratkaistavissa!");
        boolean solvable = solvabilityDeterminer.puzzeIsSolvable(puzzle);

        if (!solvable) {
            System.out.println("Peliä ei ole mahdollista ratkaista.");
            return;
        }

        System.out.println("Peli voidaan ratkaista.");
        List<Move> moves = idastar.solve();
        if (moves == null) {
            System.out.print("Ratkaisua ei löytynyt! D:");
        } else {
            System.out.println("Ratkaisu löytyi! :D");
            System.out.println("Siirrot:");
            for (int i = moves.length() - 1; i >= 0; i--) {
                //puzzle.move(moves.get(i).getDx(), moves.get(i).getDy());
                System.out.println(moves.get(i).name());
            }
            renderer.repaint();
        }
    }
}
