package solver.logic.algorithms;

import solver.logic.algorithms.heuristic.Heuristic;
import solver.logic.algorithms.heuristic.ManhattanDistance;
import solver.logic.algorithms.heuristic.ManhattanDistanceWithConflicts;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

/**
 * Luokka sisältää toiminnallisuuden lyhimmän reitin etsimiseen n-pelin lähtötilasta
 * tavoitetilaan IDA*-algoritmin avulla.
 */
public class IDAStar {

    private Heuristic heuristic;
    private int bound;
    private boolean isFinished;
    private Puzzle puzzle;
    private List<Move> moves;
    private int testingBound;

    /**
     * Konstruktori luo uuden IDA*-laskijan.
     *
     * @param puzzle Käytössä oleva pelitila
     */
    public IDAStar(Puzzle puzzle) {
        this.heuristic = new ManhattanDistanceWithConflicts(puzzle);
        this.moves = new List<>();
        this.puzzle = puzzle;
        this.testingBound = 80;
    }
    
    public IDAStar(Puzzle puzzle, int testingBound) {
        this(puzzle);
        this.testingBound = testingBound;
    }

    /**
     * Metodi ratkaisee lyhimmän reitin alkutilasta tavoitetilaan.
     *
     * @return siirrot, joita käytettiin ratkaisun saavuttamiseen
     */
    public List<Move> solve() {
        moves.clear();
        isFinished = false;
        int estimate = heuristic.getEstimate();
        bound = estimate;

        while (!(isFinished || bound > testingBound)) {
//            System.out.println("Etsitään syvyydeltä: " + bound);
            bound = search(puzzle, null, 0, estimate);
        }

        moves.reverse();
        return moves;
    }

    private int search(Puzzle current, Move lastMove, int cost, int estimate) {
        int totalCost = estimate + cost;

        if (totalCost > bound) {
            return totalCost;
        }

        if (heuristic.puzzleIsInGoalState()) {
            isFinished = true;
            return 0;
        }

        int newBound = Integer.MAX_VALUE;
        for (Move move : Move.values()) {
            if (current.canMove(move) && lastMove != move.getOpposite()) {
                current.move(move);
                Point posOfZero = current.positionOfZero();
                
                int newEstimate = heuristic.update(estimate, posOfZero.getX(), posOfZero.getY(), posOfZero.getX() - move.getDx(), posOfZero.getY() - move.getDy());
                newBound = Math.min(newBound, search(current, move, cost + 1, newEstimate));

                if (isFinished) {
                    moves.add(move);
                    return 0;
                }

                current.move(move.getOpposite());
            }
        }
        
        return newBound;
    }
}
