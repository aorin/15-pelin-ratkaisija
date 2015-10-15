package solver.logic.algorithms;

import solver.logic.algorithms.heuristic.Heuristic;
import solver.logic.algorithms.heuristic.ManhattanDistanceWithConflicts;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

/**
 * Luokka sisältää toiminnallisuuden lyhimmän reitin etsimiseen n-pelin
 * lähtötilasta tavoitetilaan IDA*-algoritmin avulla.
 */
public class IDAStar {

    private Heuristic heuristic;
    private int bound;
    private boolean isFinished;
    private Puzzle puzzle;
    private List<Move> moves;
    private long time;
    private int testingBound;

    /**
     * Konstruktori luo uuden IDA*-laskijan annetun pelin perusteella.
     *
     * @param puzzle Peli, joka halutaan ratkaista
     * @param heuristic Heuristiikka, jota käytetään ratkaisussa
     */
    public IDAStar(Puzzle puzzle, Heuristic heuristic) {
        this.moves = new List<>();
        this.puzzle = puzzle;
        this.heuristic = heuristic;
        this.isFinished = false;
        this.testingBound = 80;
    }

    /**
     * Konstruktori luo uuden IDA*-laskijan annetun pelin perusteella.
     * <p>
     * Heuristiikkana algoritmi käyttää ManhattanDistanceWithConflicts-heuristiikkaa.
     * @param puzzle Peli, joka halutaan ratkaista
     */
    public IDAStar(Puzzle puzzle) {
        this(puzzle, new ManhattanDistanceWithConflicts(puzzle));
    }

    /**
     * Metodi ratkaisee lyhimmän reitin alkutilasta tavoitetilaan.
     *
     * @return siirrot, joita käytettiin ratkaisun saavuttamiseen
     */
    public List<Move> solve() {
        if (isFinished) {
            return moves;
        }
        int estimate = heuristic.getEstimate();
        bound = estimate;

        long start = System.nanoTime();

        while (!(isFinished || bound > testingBound)) {
            bound = search(null, 0, estimate);
        }

        long end = System.nanoTime();
        time = end - start;

        moves.reverse();
        return moves;
    }

    /**
     * Metodi palauttaa ratkaisuun kuluneen ajan.
     *
     * @return Ratkaisemiseen kulunut aika nanosekunteina
     */
    public long searchTime() {
        if (!isFinished) {
            return 0;
        }
        return time;
    }

    private int search(Move lastMove, int cost, int estimate) {
        int totalCost = estimate + cost;

        if (totalCost > bound) {
            return totalCost;
        }

        if (heuristic.puzzleIsInGoalState()) {
            isFinished = true;
            return bound;
        }

        int newBound = Integer.MAX_VALUE;
        for (Move move : Move.values()) {
            if (puzzle.canMove(move) && lastMove != move.getOpposite()) {
                puzzle.move(move);
                Point posOfZero = puzzle.positionOfZero();

                int newEstimate = heuristic.update(estimate, posOfZero.getX(), posOfZero.getY(), posOfZero.getX() - move.getDx(), posOfZero.getY() - move.getDy());
                newBound = Math.min(newBound, search(move, cost + 1, newEstimate));

                if (isFinished) {
                    moves.add(move);
                    return bound;
                }

                puzzle.move(move.getOpposite());
            }
        }

        return newBound;
    }
}
