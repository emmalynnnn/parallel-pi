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

    public String getAllDigits() {
        StringBuilder sb = new StringBuilder();
        sb.append("3.");
        for (int i = 0; i < hashTable.keySet().toArray().length; i++) {
            sb.append(hashTable.get(hashTable.keySet().toArray()[i]));
        }
        return sb.toString();
    }

}