package solver.logic.algorithms;

import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Point;
import solver.logic.domain.Puzzle;

/**
 * Luokka sisältää toiminnallisuuden lyhimmän reitin etsimiseen lähtötilasta
 * tavoitetilaan IDA*-algoritmin avulla.
 */
public class IDAStar {
    private ManhattanDistance manhattan;
    private int bound;
    private boolean isFinished;
    private Puzzle start;
    private List<Move> moves;

    /**
     * Konstruktori luo uuden IDA*-laskijan.
     * @param puzzle Käytössä oleva pelitila
     */
    public IDAStar(Puzzle puzzle) {
        this.manhattan = new ManhattanDistance(puzzle);
        this.moves = new List<>();
        this.start = puzzle;
    }

    /**
     * Metodi ratkaisee lyhimmän reitin alkutilasta tavoitetilaan.
     *
     * @return siirrot, jotka käytettiin ratkaisun saavuttamiseen
     */
    public List<Move> solve() {
        moves.clear();
        isFinished = false;
        bound = manhattan.getEstimate();

        while (!isFinished) {
            bound = search(start);
        }

        return moves;
    }

    private int search(Puzzle current) {
        int totalCost = manhattan.getEstimate() + current.getCost();

        if (totalCost > bound) {
            return totalCost;
        }

        if (manhattan.getEstimate() == 0) {
            isFinished = true;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (Move move : Move.values()) {
            if (current.move(move.getDx(), move.getDy())) {
                Point posOfZero = current.positionOfZero();
                current.setCost(current.getCost() + 1);
                manhattan.update(posOfZero.getX(), posOfZero.getY(), posOfZero.getX() - move.getDx(), posOfZero.getY() - move.getDy());
                int value = search(current);
                min = Math.min(min, value);
                
                if (isFinished) {
                    moves.add(move);
                    return 0;
                }
                
                current.setCost(current.getCost() - 1);
                current.move(-1 * move.getDx(), -1 * move.getDy());
                manhattan.update(posOfZero.getX(), posOfZero.getY(), posOfZero.getX() + move.getDx(), posOfZero.getY() + move.getDy());
            }
        }

        return min;
    }
}
