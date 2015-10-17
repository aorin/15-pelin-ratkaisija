package solver.logic.algorithms.heuristic;

import solver.logic.domain.Puzzle;

/**
 * Luokka sisältää toiminnallisuuden pelin Manhattan-etäisyyden laskemiseen
 * lineaariset konfliktit mukaan huomioituna.
 */
public class ManhattanDistanceWithConflicts implements Heuristic {

    private ManhattanDistance manhattan;
    private LinearConflicts conflicts;

    /**
     * Konstruktori luo uuden laskijan annetun peliasetelman perusteella.
     *
     * @param puzzle Käytössä oleva peliasetelma
     */
    public ManhattanDistanceWithConflicts(Puzzle puzzle) {
        this.manhattan = new ManhattanDistance(puzzle);
        this.conflicts = new LinearConflicts(puzzle);
    }

    /**
     * Palauttaa asetelman Manhattan-etäisyyden lineaariset konfliktit
     * huomioituna.
     *
     * @return Peliasetelman Manhattan-etäisyys
     */
    @Override
    public int getEstimate() {
        int manhattanValue = manhattan.getEstimate();
        
        return manhattanValue + 2 * conflicts.getConflicts();
    }

    /**
     * Päivittää arvion vastaamaan uutta tilannetta
     * jonkun palan siirron jälkeen.
     *
     * @param estimate Edellisen asetelman etäisyysarvio
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     * @return Uusi arvio etäisyydestä
     */
    @Override
    public int update(int estimate, int x1, int y1, int x2, int y2) {
        estimate = manhattan.update(estimate, x1, y1, x2, y2);
        estimate += 2 * conflicts.changeBetweenStates(x1, y1, x2, y2);
        return estimate;
    }
}
