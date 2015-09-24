package solver.logic.algorithms.heuristic;

/**
 * Rajapinta heuristisille funktioille.
 * <p>
 * Heuristisen funktion tarkoituksena on arvioida, kunka pitkä
 * etäisyys lähtötilasta on maalitilaan.
 */
public interface Heuristic {
    /**
     * Metodi antaa arvion siihen, kuinka pitkä etäisyys lähtötilaan on.
     * 
     * @return Arvio etäisyydestä
     */
    public int getEstimate();
    
    /**
     * Metodi antaa päivitetyn arvion etäisyydestä lähtötilaan jonkin
     * siirron jälkeen.
     * 
     * @param estimate Vanha arvio
     * @param x1 Liikutetun palan vanha x-koordinaatti
     * @param y1 Liikutetun palan vanha y-koordinaatti
     * @param x2 Liikutetun palan uusi x-koordinaatti
     * @param y2 Liikutetun palan uusi y-koordinaatti
     * @return Uusi arvio
     */
    public int update(int estimate, int x1, int y1, int x2, int y2);
    
    /**
     * Metodi kertoo, onko peli saavuttanut tavoitetilan.
     * @return True, jos tavoitetila on saavutettu, muutoin false
     */
    public boolean puzzleIsInGoalState();
}
