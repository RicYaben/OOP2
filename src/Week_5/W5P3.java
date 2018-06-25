package Week_5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Week 3 – Problem 4
 * Write a program that uses a ​String method ​split to tokenize text into words. Place each token (word) into a ​TreeSet and print contents of this ​TreeSet afterwards. Treat words in uppercase, words in lowercase and words starting with capital letter the same.
 * Input format:
 *  A ​String (sentence/sentences with multiple words and punctuation, without apostrophes).
 * Output format:
 *  Words of the sentence in ascending alphabetical order.
 */

public class W5P3 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        words(phrase);
    }
    private static void words(String phrase){
        String[] strings = phrase.toLowerCase().replaceAll("\\p{Punct}", "").split(" ");
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList(strings));
        for(String aString : treeSet){
            System.out.print(aString + "\n");
        }
    }
}
