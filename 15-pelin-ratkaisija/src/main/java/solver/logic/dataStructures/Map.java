package solver.logic.dataStructures;

import java.util.HashMap;

public class Map<T, E> {
    private HashMap<T, E> valiaikainenMap;
    
    public Map() {
        valiaikainenMap = new HashMap<>();
    }
    
    public void put(T key, E value) {
        valiaikainenMap.put(key, value);
    }
    
    public E get(T key) {
        return valiaikainenMap.get(key);
    }
}
