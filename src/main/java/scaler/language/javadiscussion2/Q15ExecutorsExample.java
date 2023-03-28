package scaler.language.javadiscussion2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImplement implements Runnable {

  public void run() {
    System.out.println("Hello");
  }

}

public class Q15ExecutorsExample {

  public static void main(String[] args) {
    System.out.println("Inside : " + Thread.currentThread().getName());

    System.out.println("Creating Executor Service...");
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    System.out.println("Creating a Runnable...");
    Runnable runnable1 = new RunnableImplement();
    Runnable runnable2 = new RunnableImplement();
    Runnable runnable3 = new RunnableImplement();

    System.out.println("Submit the task specified by the runnable to the executor service.");
    executorService.submit(runnable1);

    executorService.submit(runnable2);

    executorService.submit(runnable3);
  }
}
//  The above code forgets to shutdown the executor thread pool.
//    The above code has no syntax errors and will be compiled error free.

//  The above code has no syntax errors and will be compiled error-free.
//    This code creates a fixed thread pool of 2 threads using the Executors.newFixedThreadPool() method and submits three Runnable objects to the pool using the ExecutorService.submit() method. The Runnable objects are instances of the RunnableImplement class, which defines a run() method that simply prints "Hello".
//    While it is true that the code does not explicitly shutdown the executor thread pool, it is not necessarily a problem as long as the application is designed to terminate after the threads in the pool have completed their tasks. However, if the application needs to run for a longer time, it is good practice to explicitly shutdown the executor service using the ExecutorService.shutdown() method to avoid any potential resource leaks.
//    Therefore, the correct choice is: "The above code has no syntax errors and will be compiled error-free."