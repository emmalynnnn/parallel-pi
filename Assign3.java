/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Runtime.getRuntime;

public class Assign3 {
    /**
     * Main method, accepts & validates user input and calls specified internal method
     * @param args the program's arguments
     */
    public static void main(String args[]) {
        TaskQueue<Integer> taskQueue = new TaskQueue<>();

        ArrayList<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < /*1001*/35; i++) {
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

        while (taskQueue.size() > 0) {
            int thisTask = taskQueue.pop();
            int digit = bpp.getNthDigit(thisTask);
            results.add(thisTask, digit);
        }

        //System.out.println(results.toString());
        System.out.println(results.getAllDigits());

        duration = System.currentTimeMillis() - duration;
        System.out.println("> " + duration + " ms");
    }

    /**
     * Method to print a usage message
     * @author Emma Lynn
     */
    private static void printUsage() {
        System.out.println("--- Assign 2 Help ---\n" +
                "  -cpu : Reports the number of CPUs (physical and logical) available.\n" +
                "  -mem : Reports the available free memory, total memory, and max memory.\n" +
                "  -dirs : Reports the process working directory and the user's home directory.\n" +
                "  -os : Reports the OS name and OS version.\n" +
                "  -java : Reports the following items about the JVM:\n" +
                "\tJava vendor\n" +
                "\tJava runtime name\n" +
                "\tJava version\n" +
                "\tJava VM version\n" +
                "\tJava VM name");
    }
}