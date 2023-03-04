public class WorkerThread extends Thread {
    TaskQueue<Integer> tasks;
    ResultTable<Integer> results;

    public WorkerThread(TaskQueue<Integer> tasks, ResultTable<Integer> results) {
        this.tasks = tasks;
        this.results = results;
    }

    @Override
    public void run() {
        BPP bpp = new BPP();
        while (tasks.size() > 0) {
            int thisTask = tasks.pop();

            //int digit = bpp.getNthDigit(thisTask);

            results.add(thisTask, calculate(bpp,thisTask));
            //results.add(thisTask, digit);
        }
    }

    private synchronized int calculate(BPP bpp, int num) {
        int digit = bpp.getNthDigit(num);
        return digit;
    }

}