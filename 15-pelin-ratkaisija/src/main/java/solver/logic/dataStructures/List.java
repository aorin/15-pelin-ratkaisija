package solver.logic.dataStructures;

/**
 * Luokka tarjoaa toiminnallisuuden olioiden listaamiseen.
 * @param <T> Olion tyyppi 
 */
public class List<T> {

    private Object[] array;
    private int n;

    /**
     * Konstruktori luo uuden tyhjän listan.
     */
    public List() {
        array = new Object[10];
        n = 0;
    }

    /**
     * Metodi lisää lisättävän alkion listan perälle.
     * @param value Lisättävä olio
     */
    public void add(T value) {
        if (n >= array.length) {
            Object[] oldArray = array;
            array = new Object[n * 10];
            for (int i = 0; i < oldArray.length; i++) {
                array[i] = oldArray[i];
            }
        }
        array[n] = value;
        n++;
    }

    /**
     * Metodi tyhjentää listan.
     */
    public void clear() {
        array = new Object[10];
        n = 0;
    }

    public T get(int i) {
        return (T) array[i];
    }

    public boolean contains(T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        
        return false;
    }

    public int length() {
        return n;
    }
}
