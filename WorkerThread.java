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

                //int digit = bpp.getNthDigit(thisTask);

                results.add(thisTask, calculate(bpp, thisTask));
                //results.add(thisTask, digit);
                numCompleted++;
                checkIfUpdate();
            }
        }
    }

    private synchronized void checkIfUpdate() {
        if ((digits - tasks.size()) % 10 == 0) {
            System.out.print((digits - tasks.size()) + " ");
        }
    }

    private synchronized int calculate(BPP bpp, int num) {
        int digit = bpp.getNthDigit(num);
        return digit;
    }

}