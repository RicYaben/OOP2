package Week_9;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Week 8 – Problem 1
 *
 * Write a program that reads an array of integers and finds the maximum value, using threads.
 *
 * Write the program in such way, that the array A is divided into 4 parts, and there is a thread searching through
 * every part separately. Each thread returns highest value from its respective part. The highest of these 4 values is
 * the maximal value of array A.
 *
 * Input format:
 *  • Integer N – number of elements in the array. (N is at least 4)
 *  • N space separated integers – elements of the array
 *
 * Output format:
 *  • Maximum value of the array
 */

public class W9P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        List<Integer> list = new LinkedList<>();
        for(int index = 0; index < length; index ++) {
            list.add(scanner.nextInt());
        }

        AtomicInteger counter = new AtomicInteger(0);
        int size = (int) Math.ceil(list.size() / 4);
        List<Integer> max = new LinkedList<>();

        Collection<List<Integer>> partitioned = list.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size)).values();
        partitioned.stream().forEach(list1 ->{
            DoSomething doSomething = new DoSomething(list1);
            try{
                Thread thread = new Thread(doSomething);
                thread.start();
                thread.join();

            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            max.add(doSomething.getMax());
        });
        System.out.print(max.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new));
    }

}
class DoSomething implements Runnable{
    private List<Integer> list;
    private int maximum;

    public DoSomething(List<Integer> list){
        this.list = list;
    }

    public void run(){
        try{
            maximum = list.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        }catch(NoSuchElementException nee){
            nee.printStackTrace();
        }

    }

    public int getMax(){
        return maximum;
    }
}