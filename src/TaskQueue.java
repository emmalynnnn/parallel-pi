public class TaskQueue<E> {
    private Queue queue = new LinkedList();

    public TaskQueue() {
    }

    public void add(E toAdd) {
        queue.add(toAdd);
    }

    public E void() {
        return queue.poll();
    }

    public void clear() {
        queue.clear();
    }


}