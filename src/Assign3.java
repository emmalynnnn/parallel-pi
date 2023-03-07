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
    static String pi = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035982534904287554687311595628638823537875937519577818577805321712268066130019278766111959092164201989";
    /**
     * Main method, accepts & validates user input and calls specified internal method
     * @param args the program's arguments
     */
    public static void main(String args[]) {
        TaskQueue<Integer> taskQueue = new TaskQueue<>();
        int DIGITS = 1000;

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

        //BPP bpp = new BPP();

        long duration = System.currentTimeMillis();

        int numCompleted = 0;

        /*while (taskQueue.size() > 0) {
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
        }*/

        int threadNum = numCores;

        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new WorkerThread(taskQueue, results, numCompleted, DIGITS);
        }

        for (int i = 0; i < threadNum; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }

        System.out.println("");
        System.out.println("");

        //System.out.println(results.toString());
        String piCalc = results.getAllDigits();
        System.out.println(piCalc);
        /*System.out.println("");

        if (piCalc.equals(pi)) {
            System.out.println("Great pi!!");
        } else {
            System.out.println("Bad bad pi :(");
        }*/

        duration = System.currentTimeMillis() - duration;
        System.out.println("Pi computation took " + duration + " ms");
    }

}