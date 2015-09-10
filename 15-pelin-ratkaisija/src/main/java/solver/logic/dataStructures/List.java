package solver.logic.dataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public class List<T> implements Iterable<T> {
    private Object[] array;
    private ArrayList<T> valiaikainenLista = new ArrayList<T>();

    public List() {
        array = new Object[10];
    }

    public void add(T value) {
        valiaikainenLista.add(value);
    }

    public void tyhjenna() {
        valiaikainenLista.clear();
    }

    public boolean contains(T value) {
//        for (int i = 0; i < luvut.length; i++) {
//            if (luvut[i] == luku) {
//                return true;
//            }
//        }
//        
//        return false;
        return valiaikainenLista.contains(value);
    }
    
    public int length() {
        return valiaikainenLista.size();
    }

    @Override
    public Iterator<T> iterator() {
        class Iteraattori<t> implements Iterator<T> {
            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public T next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }
        return valiaikainenLista.iterator();
    }
}
