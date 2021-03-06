package solver.logic.domain;

/**
 * Luokka, joka määrittelee n-pelin pelialustan.
 * <p>
 * Pelialustaan liittyviä ominaisuuksia on numeroiden sijainnit alustalla ja
 * se, kuinka monta siirtoa kyseiseen asetelmaan pääseminen vaati
 * alkuasetelmasta.
 */
public class Puzzle {

    private int[][] values;
    private int cost;
    private Point posOfZero;

    /**
     * Konstruktori luo uuden pelilaudan annettujen numeroiden alkusijaintien
     * perusteella.
     * <p>
     * Käytettyjen siirtojen määräksi asetetaan aluksi nolla.
     *
     * @param values Pelin numeroiden sijainnit
     */
    public Puzzle(int[][] values) {
        this.values = values;
        this.posOfZero = calculatePositionOfZero();
        this.cost = 0;
    }

    /**
     * Metodi palauttaa sen numeroarvon, mikä pelilaudalla on haetussa kohdassa.
     *
     * @param x Haetun kohdan x-koordinaatti
     * @param y Haetun kohdan y-koordinaatti
     * @return Numeroarvo sarakkeessa x rivillä y
     */
    public int valueAtPoint(int x, int y) {
        return this.values[x][y];
    }

    /**
     * Metodi palauttaa tiedon kaikkien numeroiden sijainnista.
     *
     * @return Tieto numeroiden sijainnista
     */
    public int[][] values() {
        return this.values;
    }
    
    /**
     * Metodi palauttaa kopion pelistä.
     * 
     * @return Kopio 
     */
    public Puzzle copy() {
        int[][] copy = new int[values.length][values.length];
        
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = values[i][j];
            }
        }
        
        return new Puzzle(copy);
    }

    /**
     * Metodi palauttaa tiedon pelilaudan leveydestä.
     *
     * @return Pelilaudan leveys
     */
    public int n() {
        return this.values.length;
    }
    
    /**
     * Metodi kertoo voiko annettu siirto tehdä.
     * 
     * @param move Tutkittava siirto
     * @return Palauttaa true, jos siirto onnistuu, muuten false
     */
    public boolean canMove(Move move) {
        if (move == Move.UP) {
            return posOfZero.getY() - 1 >= 0;
        } else if (move == Move.DOWN) {
            return posOfZero.getY() + 1 < values.length;
        } else if (move == Move.LEFT) {
            return posOfZero.getX() - 1 >= 0;
        } else {
            return posOfZero.getX() + 1 < values.length;
        }
    }

    /**
     * Metodi liikuttaa yhden palan nollan paikalle siirron mukaisesti.
     *
     * @param move Siirto
     */
    public void move(Move move) {
        int dx = move.getDx(), dy = move.getDy();
        int x0 = posOfZero.getX(), y0 = posOfZero.getY();

        values[x0][y0] = values[x0 + dx][y0 + dy];
        values[x0 + dx][y0 + dy] = 0;
        posOfZero.setX(posOfZero.getX() + dx);
        posOfZero.setY(posOfZero.getY() + dy);
    }

    /**
     * Metodi kertoo peliasetelmaan pääsemiseen vaatimien siirtojen määrän.
     *
     * @return Peliasetelmaan pääsemiseen vaatineet siirrot
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Metodi asettaa oliolle kuluneiden siirtojen määrän.
     *
     * @param cost Kuluneiden siirtojen määrä
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Metodi palauttaa tiedon siitä, missä numero nolla sijaitsee pelilaudalla
     *
     * @return Tieto nollan sijannista
     */
    public Point positionOfZero() {
        return this.posOfZero;
    }

    private Point calculatePositionOfZero() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}
