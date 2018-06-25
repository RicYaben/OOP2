package Week_4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * In this problem, 2 operations will be performed on a List:
 *  ● Insertion of element to position with said index
 *  ● Deletion of element from position with said index.
 * After the operations are performed, the modified List is displayed.
 *
 * The input consists of following:
 *  ● Integer ​N (number of elements in the List).
 *  ● N space-separated integers (elements of the List)
 *  ● Integer ​Q (number of operations to be performed)
 *  ● The Q following lines contain either one or two integers:
 *      ○ If a line c​ontains one integer ​x,the element of the List with index x has to be deleted.
 *      ○ If a line contains two integers ​x y, the integer ​y needs to be added to th​ e position with index ​x.
 *
 * The output is space-separated elements of the modified list.
 */

public class W4P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        LinkedList <Integer> linkedList = new LinkedList<>();

        for(int index  = 0; index < length; index ++){
            linkedList.add(scanner.nextInt());
        }
        int operations = scanner.nextInt();
        scanner.nextLine();
        for(int i = operations; i >=1; i--){
            String[] strings = scanner.nextLine().split(" ");

            if(strings.length == 2){
                int index = Integer.parseInt(strings[0]);
                int element = Integer.parseInt(strings[1]);
                linkedList.add(index, element);
            }else if(strings.length == 1){
                int index = Integer.parseInt(strings[0]);
                linkedList.remove(index);
            }
        }

        System.out.print(linkedList.toString().replace("[","").replace("]","").replace(",", ""));
    }
}
