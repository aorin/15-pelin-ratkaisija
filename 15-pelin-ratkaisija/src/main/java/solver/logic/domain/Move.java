package solver.logic.domain;

/**
 * Luokka määrittelee käsitteen siirto
 */
public enum Move {
    LEFT(-1, 0), RIGHT(1, 0), UP(0, -1), DOWN(0, 1);
    
    private final int dx, dy;

    private Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return this.dx;
    }
    
    public int getDy() {
        return this.dy;
    }
}
