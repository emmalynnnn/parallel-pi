/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Runtime.getRuntime;

/** TODO:
 * * Documentation
 * * Review requirments
 * * Check output
 * * Threads
 * * Race conditions?
 * * Make queue thread safe
 *      * Syncronized keyword
 * *
 */

public class Assign3 {
    /**
     * Main method, accepts & validates user input and calls specified internal method
     * @param args the program's arguments
     */
    public static void main(String args[]) {
        TaskQueue<Integer> taskQueue = new TaskQueue<>();
        int DIGITS = 100;

        ArrayList<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < DIGITS; i++) {
            tasks.add(i + 1);
        }
        Collections.shuffle(tasks);
        for (int i = 0; i < tasks.size(); i++) {
            taskQueue.push(tasks.get(i));
        }

        ResultTable<Integer> results = new ResultTable<>();

        int numCores = getRuntime().availableProcessors();

        BPP bpp = new BPP();

        long duration = System.currentTimeMillis();

        int numCompleted = 0;
        while (taskQueue.size() > 0) {
            int thisTask = taskQueue.pop();
            int digit = bpp.getNthDigit(thisTask);
            results.add(thisTask, digit);
            numCompleted++;
            if (numCompleted % 10 == 0) {
                System.out.print(".");
                if (numCompleted % 25 == 0) {
                    System.out.println("");
                }
            }
        }
        System.out.println("\n");

        //System.out.println(results.toString());
        System.out.println(results.getAllDigits());

        duration = System.currentTimeMillis() - duration;
        System.out.println("Pi computation took " + duration + " ms");
    }

}