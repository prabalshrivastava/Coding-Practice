package scaler.language.javadiscussion2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

 @Override
 public void run() {
    Counter.increment(); 
 }

}

public class RaceConditionExample {

 public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    for(int i = 0; i < 1000; i++) {
     executorService.submit(new Task());
    }

    executorService.shutdown();
    executorService.awaitTermination(60, TimeUnit.SECONDS);
 
    System.out.println("Final count is : " + Counter.getCount());
 }
}

class Counter {
 static private int count = 0;

 public static void increment() {
    count = count + 1;
 }

 public static int getCount() {
    return count;
 }
}

//Which of the following keyword can be used to prevent race condition in following code:
//volatile
//synchronized
//this
//super


//The keyword that can be used to prevent race condition in the given code is synchronized.
//In the code, the Counter class contains a static increment() method that increments the static count variable. When multiple threads execute this method simultaneously, a race condition can occur, resulting in an incorrect count.
//To prevent this race condition, we need to ensure that only one thread at a time can access the increment() method. This can be achieved by making the increment() method synchronized. When a method is synchronized, only one thread can execute it at a time, ensuring that the shared data is accessed and modified in a thread-safe manner.
//Therefore, the correct keyword that can be used to prevent race condition in this code is synchronized.