package Week_6;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Week 4 – Problem 1
 * Original source: ​https://www.hackerrank.com/challenges/phone-book
 *
 * In this problem, you will construct a simple phone book. On the input, names and associated phone numbers will
 * be provided. These should be stored using suitable implementation of ​Map interface. Each person can have up to 3
 * different numbers, labeled “home”, “work” and “mobile”.
 *
 * Further on the input will be number of queries - names and phone labels that need to be looked up. For each query,
 * a correct phone number should be outputted, if such number exists.
 *
 * See description and examples below for the precise formatting of input and output.
 *
 * Input format:
 *  ● Integer ​N - number of people in the phone book ● On following ​N*4 lines:
 *  ○ Name of the person
 *  ○ home [​phone-number]*
 *  ○ work [phone-number]*
 *  ○ mobile [phone-number]*
 *  ● Integer ​Q - number of queries
 *  ● On following ​Q lines - ​[name of the person] [phone label]
 *
 * *Not all the people have to have all three phones. If a person doesn’t have such phone, there is no number after
 * the label (e.g if a person does not own a work phone, there will be only the label “​work” followed by end-of-the-line
 * symbol). There may be people with no phone numbers in the phonebook.
 *
 * Output format
 *  ● Q lines. Each line contains the correct number belonging to the person and the phone queried. If the person does
 *    not have such number, then output the string “no number”.
 */

public class W6P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int numberConctacts = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();
        for(int index = 0; index < numberConctacts; index ++){
            HashMap<String, String> phones = new HashMap<>();
            String name = scanner.next();
            scanner.nextLine();
            for(int j = 0; j < 3; j++){
                String phoneNumber = scanner.nextLine();
                String[] strings = phoneNumber.split(" ");
                if(strings.length == 1){
                    phones.put(strings[0], "no number" );
                }else{
                    phones.put(strings[0], strings[1]);
                }
            }
            phoneBook.put(name, phones);
        }

        int phoneQueried = scanner.nextInt();
        String[] strings = new String[phoneQueried];
        scanner.nextLine();

        for(int index = 0; index < phoneQueried; index ++){
            String string = scanner.nextLine();
            strings[index] = string;
        }
        for(String aString : strings ){
            String[] strings1 = aString.split(" ");
            Map<String, String> map = phoneBook.get(strings1[0]);
            System.out.print(map.get(strings1[1]) + "\n");
        }
    }
}
