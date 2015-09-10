package solver.logic.algorithms;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.State;

public class ManhattanDistanceTest {
    private ManhattanDistance calculator;
    
    @Before
    public void setUp() {
        calculator = new ManhattanDistance();
    }
    
    @Test
    public void haveRightGoalPosition() {
        State state = new State(new int[][]{{0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}});
        assertEquals(0, calculator.getDistance(state));
    }
    
    @Test
    public void calculatesCorrectValue() {
        State state = new State(new int[][]{{10, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 0, 14}, {3, 7, 11, 15}});
        assertEquals(8, calculator.getDistance(state));
    }
}
