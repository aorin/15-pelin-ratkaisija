package solver.logic.dataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.logic.domain.Point;

public class ListTest {

    private List list;

    @Before
    public void setUp() {
        this.list = new List();
    }

    @Test
    public void lenghtOfEmptyListIsZero() {
        assertEquals(0, list.length());
    }

    @Test
    public void canAddOne() {
        String s = "hello";
        list.add(s);
        assertEquals(s, list.get(0));
        assertEquals(1, list.length());
    }

    @Test
    public void canAddMany() {
        for (int i = 0; i < 18; i++) {
            list.add(new Point(i, i));
        }
        assertEquals(18, list.length());
    }

    @Test
    public void getsRightObject() {
        for (int i = 0; i < 18; i++) {
            list.add(i);
        }
        assertEquals(15, list.get(15));
    }

    @Test
    public void clearsList() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    public void trueIfContains() {
        Point p = new Point(2, 2);
        list.add(new Point(1, 1));
        list.add(new Point(3, 3));
        list.add(p);
        list.add(new Point(1, 2));
        assertTrue(list.contains(p));
    }

    @Test
    public void falseIfDoesNotContain() {
        Point p = new Point(2, 2);
        list.add(new Point(1, 1));
        list.add(new Point(3, 3));
        list.add(new Point(1, 2));
        assertTrue(!list.contains(p));
    }
    
    @Test
    public void reversesList() {
        List<Integer> list = new List<>();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }
        
        list.reverse();
        boolean inReverseOrder = true;
        
        for (int i = 0, j = 7; i < 8; i++, j--) {
            if (list.get(i) != j) {
                inReverseOrder = false;
            }
        }
        assertTrue(inReverseOrder);
    }
}
