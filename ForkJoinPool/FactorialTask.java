package ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {
    private final int n;
   
    public FactorialTask(int n) { 
        this.n = n; 
    }

    @Override
    public Integer compute() {
        if (n <= 1)
          return n;
        FactorialTask f1 = new FactorialTask(n - 1);
        f1.fork();
        FactorialTask f2 = new FactorialTask(n - 2);
        return f2.compute() + f1.join();
      }
}
