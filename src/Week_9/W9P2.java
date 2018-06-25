package Week_9;

/**
 * Week 8 – Problem 2
 * 
 * Source: http://www.cs.carleton.edu/faculty/dmusican/cs348/java_multi/#sec-3
 * Write a program called ReverseHello.java that creates a thread (let's call it Thread 1). Thread 1 creates another
 * thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 10. Each thread should print "Hello from
 * Thread <num>!", but you should structure your program such that the threads print their greetings in reverse order.
 */

public class W9P2 {
    public static void main(String[]arg){
        Thread thread = new Thread(new Threads());
        thread.start();

    }
}
class Threads implements Runnable{
    private Thread thread;
    private int threadNumb = 0;

    public void run() {
        if(threadNumb < 10){
            threadNumb++;
            Threads threads = new Threads();
            threads.setThreadNumb(threadNumb);
            thread = new Thread(threads);
            thread.start();

            try{
                thread.join();
                System.out.println("Hello from Thread " + threadNumb + "!");
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }

        }
    }

    private void setThreadNumb(int threadNumb) {
        this.threadNumb = threadNumb;
    }
}
