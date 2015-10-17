package solver;

import javax.swing.SwingUtilities;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.Window;

/**
 * Luokka ohjelman käynnistämistä varten.
 */
public class App {

    private Window window;
    private GameboardGenerator generator;
    private Puzzle puzzle;
    private int heuristicNro;
    private List<Move> moves;

    /**
     * Konstruktori luo ohjelmalle uuden satunnaisen 15-pelin.
     */
    public App() {
        generator = new GameboardGenerator();
        puzzle = new Puzzle(generator.generate4x4());
        window = new Window(this);
    }

    /**
     * Metodi käynnistää ohjelman avaamalla graafisen käyttöliittymäikkunan.
     */
    public void start() {
        SwingUtilities.invokeLater(window);
    }
    
    /**
     * Metodi vaihtaa käytössä olevan pelin uuteen.
     * 
     * @param newPuzzle Uusi peli 
     */
    public void changePuzzle(Puzzle newPuzzle) {
        puzzle = newPuzzle;
        window.update();
    }
    
    /**
     * Metodi vaihtaa käytössä olevan pelin ja samalla luo
     * uuden käyttöliittymäikkunan vastaamaan pelin kokoa.
     * 
     * @param newPuzzle Uusi peli
     */
    public void changePuzzleAndSize(Puzzle newPuzzle) {
        window.close();
        puzzle = newPuzzle;
        window = new Window(this);
        start();
    }

    /**
     * Metodi palauttaa pelin.
     * 
     * @return Käytössä oleva peli 
     */
    public Puzzle getPuzzle() {
        return puzzle;
    }
    
    /**
     * Metodi palauttaa uusien pelien arpojan.
     * 
     * @return Peligeneraattori
     */
    public GameboardGenerator getGenerator() {
        return generator;
    }
    
    /**
     * Metodi palauttaa pelin sivun pituuden.
     * 
     * @return Pelilaudan sivun pituus 
     */
    public int getN() {
        return puzzle.n();
    }
    
    /**
     * Palauttaa käytössä olevan heurestiikan numeron.
     * <p>
     * 0 = ManhattanDistanceWithLinearConflicts, 1 = ManhattanDistance
     * 
     * @return Heurestiikan numero 
     */
    public int getHeuresticNro() {
        return heuristicNro;
    }
    
    /**
     * Vaihtaa käytössä olevaa heurestiikkaa.
     */
    public void changeHeuristic() {
        if (heuristicNro == 0) {
            heuristicNro++;
        } else {
            heuristicNro = 0;
        }
    }
    
    /**
     * Metodi palauttaa pelin ratkaisemisessa saadut siirrot.
     * 
     * @return Siirrot; 
     */
    public List<Move> getMoves() {
        return moves;
    }
    
    /**
     * Metodi asettaa pelin ratkaisemiseen tarvittavat siirrot.
     * 
     * @param moves Siirrot
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
