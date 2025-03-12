package ForkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int n = 10; // Вычисление факториала для числа 10

        ForkJoinPool  forkJoinPool  = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);
        forkJoinPool.close();
        
        System.out.println("Факториал " + n + "! = " + result);
    }
}
