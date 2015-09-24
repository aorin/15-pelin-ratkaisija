package solver.logic.algorithms;

import solver.logic.dataStructures.List;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

/**
 * Luokka mahdollistaa IDAStar-algoritmin tehokkuuden testauksen-
 */
public class IDAStarEfficiencyTester {

    private IDAStar idastar;
    private GameboardGenerator generator;

    public IDAStarEfficiencyTester() {
        this.generator = new GameboardGenerator();
    }

    public double test15PuzzlesUnder40Moves(int n) {
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            idastar = new IDAStar(new Puzzle(generator.generate4x4()), 40);
            sum += testSolving();
        }
        
        return (double) sum / n;
    }

    private long testSolving() {
        long start, end;
        
        while (true) {
            start = System.currentTimeMillis();
            List list = idastar.solve();
            end = System.currentTimeMillis();
            if (list != null) {
                break;
            }
        }

        return end - start;
    }
}
