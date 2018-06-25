package Week_6;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class W6P2 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int entries = scanner.nextInt();
        scanner.nextLine();

        TreeSet<Pair> treeSet = new TreeSet<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int index = 0; index < entries; index ++){
            String[] strings = scanner.nextLine().split(" ");
            Pair pair = new Pair(strings[0], strings[1]);
            treeSet.add(pair);

            for(Pair aPair : treeSet){
                pair.compareTo(aPair);
            }
            linkedList.add(treeSet.size());
        }

        for(int inte: linkedList){
            System.out.print(inte + "\n");
        }
    }
}

class Pair  implements Comparable<Pair>{

    private String first;
    private String second;

    Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        int cmp = compare(first, o.second);
        return cmp == 0 ? compare(second, o.first) : cmp;
    }

    private <T extends Comparable<T>> int compare(T o1, T o2){
        if(o1 == null){
            if(o2== null){
                return 0;
            }else{
                return -1;
            }
        }else if(o2 == null){
            return +1;
        }else{
            return o1.compareTo(o2);
        }
    }

    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}
