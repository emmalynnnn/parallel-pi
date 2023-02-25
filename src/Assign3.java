/**
 * Emma Lynn
 * a02391851@usu.edu
 * Assignment 3
 */

public class Assign3 {
    /**
     * Main method, accepts & validates user input and calls specified internal method
     * @param args the program's arguments
     */
    public static void main(String args[]) {
        /*if (args.length < 1) {
            printUsage();
        }*/

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-cpu":
                    cpu();
                    break;
                case "-mem":
                    mem();
                    break;
                case "-dirs":
                    dirs();
                    break;
                case "-os":
                    os();
                    break;
                case "-java":
                    javaInfo();
                    break;
                //default:
                //System.out.println("Unknown command line argument: " + args[i]);
            }
        }
    }

    /**
     * Method to report the number of CPUs available
     * @author Emma Lynn
     */
    private static void cpu() {
        int processors = getRuntime().availableProcessors();
        System.out.println("Processors\t: " + processors);
    }

    /**
     * Method to report the available free memory, total memory, and max memory
     * @author Emma Lynn
     */
    private static void mem() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        long freeMem = getRuntime().freeMemory();
        long totalMem = getRuntime().totalMemory();
        long maxMem = getRuntime().maxMemory();
        System.out.println("Free Memory\t:\t" + nf.format(freeMem) + "\n" +
                "Total Memory\t:\t" + nf.format(totalMem) + "\n" +
                "Max Memory\t:\t" + nf.format(maxMem));
    }

    /**
     * Method to report the process's working directory and the user's home directory
     * @author Emma Lynn
     */
    private static void dirs() {
        String workDir = System.getProperty("user.dir");
        String homeDir = System.getProperty("user.home");
        System.out.println("Working Directory\t: " + workDir + "\n" +
                "User Home Directory\t: " + homeDir);
    }

    /**
     * Method to report the os name and version
     * @author Emma Lynn
     */
    private static void os() {
        String name = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        System.out.println("OS Name\t\t: " + name + "\n" +
                "OS Version\t: " + version);
    }

    /**
     * Method to report information about the JVM
     * @author Emma Lynn
     */
    private static void javaInfo() {
        String vendor = System.getProperty("java.vendor");
        String runtime = System.getProperty("java.runtime.name");
        String version = System.getProperty("java.version");
        String vmVersion = System.getProperty("java.vm.version");
        String vmName = System.getProperty("java.vm.name");
        System.out.println("Java Vendor\t: " + vendor + "\n" +
                "Java Runtime\t: " + runtime + "\n" +
                "Java Version\t: " + version + "\n" +
                "Java VM Version\t: " + vmVersion + "\n" +
                "Java VM Name\t: " + vmName);
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