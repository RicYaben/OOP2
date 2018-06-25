package Week_5;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Week 3 – Problem 5
 * Prime factors are primes that divide said number exactly. Prime factorisation is the list of prime factors of a
 * number, together with their multiplicities (​Wikipedia​). Prime factors of 36 are 2, 2, 3, 3,
 * because 2 x 2 x 3 x 3 = 36. Each positive integer has unique prime factorisation. Prime factorisation of a prime
 * number only includes said number (prime factorisation of 31 is 31).
 *
 * Write a program, that displays unique prime factors of a number. If a number is a prime, display “[x] is a prime”
 * Use sets in your solution.
 *
 * Input format:
 *  N - Positive integer.
 * Output format:
 *  space separated prime factors of N in ascending order (if number is not a prime)
 *  ”[N] is a prime” (if number is a prime)
 */

public class W5P2 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        primeNumber(number);
    }
    private static void primeNumber(int number){
        TreeSet<Integer> set = new TreeSet<>();
        for(int index = 2; index <= number; index ++){
            int temp = 0;
            for(int j = 1; j <= index; j++){
                if(index % j == 0){
                    temp ++;
                }
            }
            if(temp == 2 && number % index == 0){
                set.add(index);
                number /= index;
            }
        }
        if(set.size() == 1){
            System.out.print(set.toString().replaceAll("\\p{Punct}","") + " is a prime");
        }else{
            System.out.print(set.toString().replaceAll("\\p{Punct}", ""));
        }
    }
}
