package solver.logic.dataStructures;

/**
 * Luokka tarjoaa toiminnallisuuden olioiden listaamiseen.
 * @param <T> Olion tyyppi 
 */
public class List<T> {

    private Object[] array;
    private int n, i;

    /**
     * Konstruktori luo uuden tyhjän listan.
     */
    public List() {
        array = new Object[10];
        n = 0;
        i = 0;
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

    /**
     * Metodi hakee arvon indeksin perusteella.
     * @param i Indeksi
     * @return Indeksin kohdalla oleva arvo
     */
    public T get(int i) {
        return (T) array[i];
    }

    /**
     * Metodi kertoo sisältääkö lista haettavan arvon.
     * @param value Haettava olio
     * @return Palauttaa true, jos listalla on haettava olio, muuten false
     */
    public boolean contains(T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Metodi kertoo listan pituuden
     * @return Listan pituus
     */
    public int length() {
        return n;
    }
    
    /**
     * Metodi kääntää listan.
     */
    public void reverse() {
        for (int i = 0; i < n / 2; i++) {
            Object value = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = value;
        }
    }

    /**
     * Palauttaa indeksin.
     * 
     * @return Indeksi 
     */
    public int getI() {
        return i;
    }

    /**
     * Asettaa listalle indeksin.
     * 
     * @param i Indeksi 
     */
    public void setI(int i) {
        this.i = i;
    }
}