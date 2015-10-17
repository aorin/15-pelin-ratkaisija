package solver;

import javax.swing.SwingUtilities;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.Window;

public class App {

    private Window window;
    private GameboardGenerator generator;
    private Puzzle puzzle;
    private int heuristicNro;

    public App() {
        generator = new GameboardGenerator();
        puzzle = new Puzzle(generator.generate4x4());
        window = new Window(this);
    }

    public void start() {
        SwingUtilities.invokeLater(window);
    }
    
    public void changePuzzle(Puzzle newPuzzle) {
        puzzle = newPuzzle;
        window.update();
    }
    
    public void changePuzzleAndSize(Puzzle newPuzzle) {
        window.close();
        puzzle = newPuzzle;
        window = new Window(this);
        start();
    }

    public void closeWindow() {
        window.close();
    }
    
    public Puzzle getPuzzle() {
        return puzzle;
    }
    
    public GameboardGenerator getGenerator() {
        return generator;
    }
    
    public int getN() {
        return puzzle.n();
    }
    
    public int getHeuresticNro() {
        return heuristicNro;
    }
    
    public void changeHeuristic() {
        if (heuristicNro == 0) {
            heuristicNro++;
        } else {
            heuristicNro = 0;
        }
    }
}
