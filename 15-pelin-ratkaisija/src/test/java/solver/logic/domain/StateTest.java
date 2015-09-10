package solver.logic.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.dataStructures.List;
import solver.logic.util.GameboardGenerator;

public class StateTest {
    private GameboardGenerator generator;
    private State state;
    
    @Before
    public void setUp() {
        generator = new GameboardGenerator();
        state = new State(generator.generate());
    }
    
    @Test
    public void returnsCorrectValueAtPoint() {
        state = new State(new int[][] {{0, 1}, {2, 3}});
        assertEquals(1, state.valueAtPoint(0, 1));
    }
    
    @Test
    public void returnsAllValues() {
        int[][] values = state.values();
        assertEquals(4, values.length);
    }
    
    @Test
    public void numberOfNextStatesIsCorrect() {
       state = new State(new int[][] {{2, 1}, {0, 3}});
       assertEquals(2, state.nextStates().length());
    }
    
    @Test
    public void returnsCorrectNextStates() {
        state = new State(new int[][] {{2, 1}, {0, 3}});
        List<State> nextStates = state.nextStates();
        
        assertTrue(nextStates.contains(new State(new int[][]{{0, 1}, {2, 3}})) && nextStates.contains(new State(new int[][]{{2, 1}, {3, 0}})));
    }
}