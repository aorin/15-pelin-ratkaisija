package solver.logic.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void createNewPoint() {
        Point point = new Point(2, 3);
        assertEquals(2, point.getX());
        assertEquals(3, point.getY());
    }
}
