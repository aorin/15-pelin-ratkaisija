package solver.logic.algorithms.heuristic;

import solver.logic.domain.Puzzle;

/**
 * 
 */
public class ManhattanDistanceWithConflicts implements Heuristic {
    private ManhattanDistance manhattan;
    private LinearConflicts conflicts;
    
    public ManhattanDistanceWithConflicts(Puzzle puzzle) {
        this.manhattan = new ManhattanDistance(puzzle);
        this.conflicts = new LinearConflicts(puzzle);
    }
    
    @Override
    public int getEstimate() {
        return manhattan.getEstimate() + conflicts.getConflicts();
    }

    @Override
    public int update(int estimate, int x1, int y1, int x2, int y2) {
        estimate = manhattan.update(estimate, x1, y1, x2, y2);
        estimate = conflicts.update(estimate, x1, y1, x2, y2);
        return estimate;
    }
}
