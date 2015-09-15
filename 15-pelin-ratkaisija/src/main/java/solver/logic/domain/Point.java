package solver.logic.domain;

/**
 * Luokka määrittelee käsitteen piste.
 */
public class Point {
    private int x, y;
    
    /**
     * Konstruktori luo uuden pisteen annettujen sijaintitietojen perusteella.
     * @param x Pisteen x-koordinaatti
     * @param y Pisteen y-koordinaatti
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
