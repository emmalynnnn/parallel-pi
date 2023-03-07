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

    public WorkerThread(TaskQueue<Integer> tasks, ResultTable<Integer> results, int numCompleted, int digits) {
        this.tasks = tasks;
        this.results = results;
        this.numCompleted = numCompleted;
        this.digits = digits;
    }

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

    private synchronized void checkIfUpdate(int tasksRemaining) {
        if ((digits - tasksRemaining) % 10 == 0) {
            System.out.print(".");
            System.out.flush();
        }

        /*if ((digits - tasksRemaining) % 50 == 0) {
            //System.out.println(".");
            System.out.println((digits - tasksRemaining) + " ");
            System.out.flush();
        } else if ((digits - tasksRemaining) % 10 == 0) {
            //System.out.print((digits - tasksRemaining) + "(" + Thread.currentThread().getId() + ") ");
            //System.out.print(".");
            System.out.print((digits - tasksRemaining) + " ");
            System.out.flush();
        }*/
    }

}