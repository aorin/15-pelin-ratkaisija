package solver.logic.domain;

/**
 * Luokka määrittelee käsitteen siirto
 */
public enum Move {

    LEFT(-1, 0), RIGHT(1, 0), UP(0, -1), DOWN(0, 1);

    private final int dx, dy;
    private Move opposite;

    private Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }
    
    /**
     * Metodi palauttaa kyseisen siirron vastakkaisen siirron.
     * 
     * @return Vastakkainen siirto 
     */
    public Move getOpposite() {
        return this.opposite;
    }
}