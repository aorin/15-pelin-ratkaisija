package solver.logic.efficiencyTests;

import solver.logic.algorithms.IDAStar;
import solver.logic.algorithms.heuristic.ManhattanDistance;
import solver.logic.algorithms.heuristic.ManhattanDistanceWithConflicts;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;

public class IDAStarEfficiencyTest {

    private IDAStar idastar;
    private GameboardGenerator generator;
    private ExamplePuzzles puzzles;

    public IDAStarEfficiencyTest() {
        this.generator = new GameboardGenerator();
        this.puzzles = new ExamplePuzzles();
    }

    public long test15PuzzleManhattan(int n, int size) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = puzzles.get15Puzzle(size).copy();
            idastar = new IDAStar(p, new ManhattanDistance(p));
            idastar.solve();
            sum += idastar.searchTime();
        }

        return sum / n;
    }

    public long test15PuzzleManhattanWithConflicts(int n, int size) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = puzzles.get15Puzzle(size).copy();
            idastar = new IDAStar(p, new ManhattanDistanceWithConflicts(p));
            idastar.solve();
            sum += idastar.searchTime();
        }

        return sum / n;
    }

    public long test8PuzzleManhattan(int n, int size) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = puzzles.get8Puzzle(size).copy();
            idastar = new IDAStar(p, new ManhattanDistance(p));
            idastar.solve();
            sum += idastar.searchTime();
        }

        return sum / n;
    }

    public long test8PuzzleManhattanWithConflicts(int n, int size) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            Puzzle p = puzzles.get8Puzzle(size).copy();
            idastar = new IDAStar(p, new ManhattanDistanceWithConflicts(p));
            idastar.solve();
            sum += idastar.searchTime();
        }

        return sum / n;
    }
}
