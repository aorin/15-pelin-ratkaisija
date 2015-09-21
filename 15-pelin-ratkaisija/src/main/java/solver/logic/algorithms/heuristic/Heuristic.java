package solver.logic.algorithms.heuristic;

/**
 * Rajapinta heuristisille funktioille.
 * <p>
 * Heuristisen funktion tarkoituksena on arvioida, kunka pitkä
 * etäisyys lähtötilasta on maalitilaan.
 */
public interface Heuristic {
    public int getEstimate();
    
    public int update(int estimate, int x1, int y1, int x2, int y2);
}
