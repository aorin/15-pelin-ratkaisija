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
    private Mover mover;

    public SolveButtonListener(Puzzle puzzle, Renderer renderer) {
        this.puzzle = puzzle;
        this.renderer = renderer;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
        this.mover = new Mover(renderer);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Tarkistetaan, onko peli ratkaistavissa!");
        boolean solvable = solvabilityDeterminer.puzzeIsSolvable(puzzle);

        if (!solvable) {
            System.out.println("Peliä ei ole mahdollista ratkaista.");
            return;
        }

        Puzzle copy = puzzle.copy();
        this.idastar = new IDAStar(copy);

        System.out.println("Peli voidaan ratkaista.");
        List<Move> moves = idastar.solve();
        if (moves == null) {
            System.out.print("Ratkaisua ei löytynyt! D:");
        } else {
            mover.move(puzzle, moves);
            System.out.println("Ratkaisu löytyi! :D");
            System.out.println("Siirrot:");
            for (int i = 0; i < moves.length(); i++) {
                System.out.println(moves.get(i).name());
            }
        }
    }
}
