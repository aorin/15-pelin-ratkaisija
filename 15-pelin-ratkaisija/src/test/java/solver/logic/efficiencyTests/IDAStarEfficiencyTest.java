package solver.logic.efficiencyTests;

import solver.logic.algorithms.IDAStar;
import solver.logic.util.GameboardGenerator;

public class IDAStarEfficiencyTest {

    private IDAStar idastar;
    private GameboardGenerator generator;
    private ExamplePuzzles puzzles;

    public IDAStarEfficiencyTest() {
        this.generator = new GameboardGenerator();
        this.puzzles = new ExamplePuzzles();
    }

//    public long test15Puzzle(int n, int size) {
//        idastar = new IDAStar();
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            idastar.solve(puzzles.getPuzzle(size));
//            sum += idastar.searchTime();
//        }
//
//        return sum / n;
//    }

//    public long testRandom15Puzzles(int n, int bound) {
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            idastar = new IDAStar(new Puzzle(generator.generate4x4()), bound);
//            sum += testSolving();
//        }
//
//        return sum / n;
//    }
//
//    public long testRandom8Puzzles(int n, int bound) {
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            idastar = new IDAStar(new Puzzle(generator.generate3x3()), bound);
//            sum += testSolving();
//        }
//
//        return sum / n;
//    }
//    private long testSolving() {
//        long start, end;
//
//        while (true) {
//            start = System.nanoTime();
//            List list = idastar.solve();
//            end = System.nanoTime();
//            if (list != null) {
//                break;
//            }
//        }
//
//        return end - start;
//    }
}
