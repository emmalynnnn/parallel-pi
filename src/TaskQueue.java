import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskQueue<E> {
    private List<E> queue = Collections.synchronizedList(new LinkedList<>());

    public TaskQueue() {
        //constructor
    }

    public void push(E toAdd) {
        queue.add(toAdd);
    }

    public E pop() {
        E element = queue.get(0);
        queue.remove(0);
        return element;
    }

    public void clear() {
        queue.clear();
    }

    public String toString() {
        return queue.toString();
    }

    public int size() {
        return queue.size();
    }

}