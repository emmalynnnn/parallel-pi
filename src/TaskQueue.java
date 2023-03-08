/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskQueue<E> {
    private List<E> queue = Collections.synchronizedList(new LinkedList<>());

    public TaskQueue() {
        //constructor
    }

    /**
     * Method to add to the queue
     * @param toAdd the item to add
     */
    public void push(E toAdd) {
        queue.add(toAdd);
    }

    /**
     * Method to remove and return the first item in the queue
     * @return the first item from the queue
     */
    public E pop() {
        return queue.remove(0);
    }

    /**
     * Clears queue
     */
    public void clear() {
        queue.clear();
    }

    /**
     * Method to get a string representation of the queue
     * @return a string representation of the queue
     */
    public String toString() {
        return queue.toString();
    }

    /**
     * Method to get the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return queue.size();
    }

}