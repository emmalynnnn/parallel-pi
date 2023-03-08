/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

public class WorkerThread extends Thread {
    TaskQueue<Integer> tasks;
    ResultTable<Integer> results;
    int numCompleted;
    int digits;

    /**
     * Constructor for WorkerThread
     * @param tasks the queue of tasks
     * @param results the hash table holding results
     * @param numCompleted the number of tasks completed
     * @param digits the number of digits to compute
     */
    public WorkerThread(TaskQueue<Integer> tasks, ResultTable<Integer> results, int numCompleted, int digits) {
        this.tasks = tasks;
        this.results = results;
        this.numCompleted = numCompleted;
        this.digits = digits;
    }

    /**
     * Method to run the thread
     */
    @Override
    public void run() {
        synchronized (this) {
            BPP bpp = new BPP();
            while (tasks.size() > 0) {
                int thisTask = tasks.pop();
                int tasksRemaining = tasks.size();
                int digit = bpp.getNthDigit(thisTask);
                results.add(thisTask, digit);
                numCompleted++;
                checkIfUpdate(tasksRemaining);
            }
        }
    }

    /**
     * Method to check if a dot needs to be printed to display progress
     * @param tasksRemaining the number of digits left to compute
     */
    private synchronized void checkIfUpdate(int tasksRemaining) {
        if ((digits - tasksRemaining) % 10 == 0) {
            System.out.print(".");
            System.out.flush();
        }
    }

}