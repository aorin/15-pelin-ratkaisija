package solver.logic.algorithms;

import solver.logic.dataStructures.List;
import solver.logic.domain.State;

/*
 * Luokka sisältää toiminnallisuuden lyhimmän reitin etsimiseen lähtötilasta
 * tavoitetilaan IDA*-algoritmin avulla. Toteutus vielä kesken
 */
public class IDAStar {
    private ManhattanDistance manhattan;
    private int bound;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean isFinished;
    private State solution = null;

    public IDAStar() {
        manhattan = new ManhattanDistance();
    }

    /**
     * Metodi ratkaisee lyhimmän reitin alkutilasta tavoitetilaan.
     *
     * @param start alkutila
     * @return saavutettu ratkaisutila. Jos ratkaisua ei saavutettu, palauttaa
     * null-arvon
     */
    public State solve(State start) {
        isFinished = false;
        bound = manhattan.getDistance(start);

        while (!isFinished) {
            search(start);
        }
        
        return solution;
    }

    private void search(State current) {
        int totalCost = manhattan.getDistance(current) + current.getCost();

        if (totalCost > bound) {
            bound = totalCost;
            return;
        }

        if (manhattan.getDistance(current) == 0) {
            solution = current;
            return;
        }

        for (int i = 0; i < directions.length; i++) {
            if (current.move(directions[i][0], directions[i][1])) {
                State state = new State(current.values());
                state.setCost(current.getCost() + 1);
                search(current);
                if (isFinished) {
                    return;
                }
                current.move(-1*directions[i][0], -1*directions[i][1]);
            }
        }
    }
}
