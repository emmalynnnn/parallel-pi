import java.util.HashMap;
import java.util.Map;

public class ResultTable<E> {
    private Map<E, E> hashTable = new HashMap();

    public ResultTable() {
        //constructor
    }

    public void add(E key, E value) {
        hashTable.put(key, value);
    }

    public E get(E key) {
        return hashTable.get(key);
    }

    public void clear() {
        hashTable.clear();
    }

    public String toString() {
        return hashTable.toString();
    }

}