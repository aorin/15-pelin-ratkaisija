package solver.logic.efficiencyTests;

import solver.logic.algorithms.SolvabilityDeterminer;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

public class SolvabilityDeterminerEfficiencyTest {

    private SolvabilityDeterminer d;
    private GameboardGenerator g;

    public SolvabilityDeterminerEfficiencyTest() {
        d = new SolvabilityDeterminer();
        g = new GameboardGenerator();
    }

    public long test15Puzzle(int n) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = new Puzzle(g.generate4x4());
            long start = System.nanoTime();
            d.puzzleIsSolvable(p);
            long end = System.nanoTime();
            sum += end - start;
        }

        return sum / n;
    }

    public long test8Puzzle(int n) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = new Puzzle(g.generate3x3());
            long start = System.nanoTime();
            d.puzzleIsSolvable(p);
            long end = System.nanoTime();
            sum += end - start;
        }

        return sum / n;
    }
}
