package Week_5;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Week 3 – Problem 3
 * Write a program that counts, how many times each word is used in a sentence. Use a ​Map<String, Integer> to achieve this. Treat uppercase and lowercase letters the same and ignore punctuation.
 * Input format:
 * A ​String containing uppercase, lowercase letters and punctuation, but no apostrophes.
 * Output format:
 * The output should list the unique words and count how many times they appear in the sentence.
 * Each line of output should contain a ​String representing one unique word and an ​Integer describing number of occurrences, separated by space (see example).
 * The order of the words in the output should be as they appear in the sentence (try​ using ​LinkedHashMap to achieve this).
 */

public class W5P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        countWords(string);
    }
    private static void countWords(String string){

        String[] strings = string.toLowerCase().replaceAll("\\p{Punct}", "").split(" "); //Removes punctuation only and separate the words
        LinkedHashMap <String, Integer> linkedHashMap = new LinkedHashMap<>();
        for(String aString : strings){
            if(linkedHashMap.containsKey(aString)){
                linkedHashMap.replace(aString, linkedHashMap.get(aString) +1);
            }else{
                linkedHashMap.putIfAbsent(aString, 1);
            }
        }
        for(String aString : linkedHashMap.keySet()){
            System.out.print(aString + " " + linkedHashMap.get(aString) + "\n");
        }
    }
}
