package solver.logic.algorithms;

import solver.logic.dataStructures.List;
import solver.logic.domain.State;

public class IDAStar {

    private List<State> visitedStates;
    private ManhattanDistance manhattan;
    private int bound;
    private State goal;

    public IDAStar() {
        visitedStates = new List();
        manhattan = new ManhattanDistance();
    }

    public State solve(State start) {
        State solution = null;
        bound = manhattan.getDistance(start);

        while (solution == null) {
            visitedStates.add(start);
            solution = search(start);
            visitedStates.tyhjenna();
        }

        return solution;
    }

    private State search(State current) {
        State solution = null;

        for (State state : current.nextStates()) {
            if (state.equals(goal)) {
                state.setPrevious(current);
                return state;
            }

            if (!visitedStates.contains(state)) {
                state.setCost(current.getCost() + 1);
                state.setPrevious(current);
                
                int totalCost = manhattan.getDistance(state) + state.getCost();
                if (totalCost <= bound) {
                    visitedStates.add(state);
                    solution = search(state);
                } else {
                    bound = totalCost;
                }
            }
        }
        return solution;
    }
}
