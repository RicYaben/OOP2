package Week_7;
import java.util.Scanner;

/**
 * Week 6 – Problem 1
 * The aim of this problem is to exercise lambda expressions. The problem is very simple and can be solved easily using
 * ‘traditional’ Java techniques, but please, try solving it using lambdas. You will need to implement a ​functional
 * interface​, which will be used by the lambda expression. Be aware that you need to use Java 8 for lambda expressions
 * to work.
 *
 * The program will calculate the sum of pairs of doubles and print out the result of each sum.
 *
 * Input format:
 *  ● Integer N - number of pairs
 *  ● Following N lines: space separated double values
 *
 * Output format:
 *  ● N lines - each containing a double - the result of sum of respective pair. Print it out with precision of 2
 *    decimal points.
 */

public class W7P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int numPair = scanner.nextInt();
        double[] doubles = new double[numPair];
        for(int index = 0; index < numPair; index ++){
            doubles[index] = MyFunctionInterface.sum.myFunction(scanner.nextDouble(), scanner.nextDouble());
        }
        for(double aDouble : doubles){
            System.out.printf("%.2f%n",aDouble);
        }
    }
}

@FunctionalInterface
interface MyFunctionInterface {
    double myFunction(double a, double b);
    MyFunctionInterface sum = (a, b) -> a + b;
}


