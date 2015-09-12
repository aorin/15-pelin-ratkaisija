package solver.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import solver.logic.algorithms.IDAStar;
import solver.logic.algorithms.SolvabilityDeterminer;
import solver.logic.domain.State;

public class SolveButtonListener implements ActionListener {
    private State gameState;
    private SolvabilityDeterminer solvabilityDeterminer;
    private IDAStar idastar;

    public SolveButtonListener(State state) {
        this.gameState = state;
        this.solvabilityDeterminer = new SolvabilityDeterminer();
        this.idastar = new IDAStar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Tarkistetaan, onko peli ratkaistavissa!");
        boolean solvable = solvabilityDeterminer.puzzeIsSolvable(gameState.values());
        
        if (!solvable) {
            System.out.println("Peliä ei ole mahdollista ratkaista.");
        } 
        
        System.out.println("Peli voidaan ratkaista.");
        State solution = idastar.solve(gameState);
        if (solution == null) {
            System.out.print("Ratkaisua ei löytynyt! D:");
        } else {
            System.out.println("Ratkaisu löytyi! :D");
        }
    }
}
