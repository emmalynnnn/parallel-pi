import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue<E> {
    private Queue<E> queue = new LinkedList();

    public TaskQueue() {
        //constructor
    }

    public void push(E toAdd) {
        queue.add(toAdd);
    }

    public E pop() {
        return queue.poll();
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