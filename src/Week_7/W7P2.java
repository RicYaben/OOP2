package Week_7;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Week 6 – Problem 2
 * In this exercise, you will be asked to get statistical values (namely: max, min, average and sum) of some group of
 * integers. To achieve this, you are asked to process said group of integers as a ​stream and then get the values from
 * this stream using ​IntSummaryStatistics​. ​IntSummaryStatistics is a defined Java class designed to work with stream,
 * that can automatically calculate said statistic values. You can find information about ​IntSummaryStatistics​ ​here​:
 * https://docs.oracle.com/javase/8/docs/api/java/util/IntSummaryStatistics.html
 *
 * Similarly as in previous problem, there is a ‘trivial’ solution that does not involve streams. Finding this solution
 * is not the aim of this exercise.
 *
 * Input format:
 *  ● Integer ​N
 *  ● N​ lines of Integers (set A of integers)
 *
 * Output format:
 *  ● Minimal value of the set A (integer)
 *  ● Maximal value of the set A (integer)
 *  ● Average value of the set A (double - display with 2 decimal places)
 *  ● Sum of the elements in set A (integer)
 */

public class W7P2 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        int[] values = new int[integer];
        for(int index = 0; index < integer; index ++){
            values[index] = scanner.nextInt();
        }
        IntSummaryStatistics istats = IntStream.of(values).collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);

        System.out.printf("%d%n%d%n%.2f%n%d", istats.getMin(), istats.getMax(), istats.getAverage(), istats.getSum());
    }
}
