package Week_6;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Week 4 – Problem 1
 * In this problem, you will create simple program to manage invitations to a party, using ​your own implementatio​ n of
 * a ​Set<E> data structure.
 * The exercise will consist of 4 parts:
 *
 * 1. On the input there will be names of people want to invite. Some of the names may be listed more than once. You
 * should add these to the set.
 *
 * 2. Afterwards, you realize, you don’t want to invite certain people anymore. There will be list of people you’ve
 * decided to ‘uninvite’. You
 *    will need to delete these from the set.
 *
 * 3. Later,your friend asks you,if you invited person ​"A" to the party.You  will need to check the​ set and return ​true,
 * if person ​A is still invited, ​false if not.
 *
 * 4. At the very end, you will simply need to output the number of people that are invited to the party, after all
 * other operations have been performed (output the size of the set).
 *
 * How to do it:
 * In this exercise, you are asked to implement a​ generic class ​Set<E> using LinkedList. The implementation should
 * contain following methods:
 *  ● boolean add(E e);
 *  ● boolean contains(E e);
 *  ● boolean remove(E e);
 *  ● int size();
 * The implementation should have the main property of sets - it should not contain duplicate elements.
 *
 * In class names ​Solution include the ​main method and create object of the class ​Set​ . Call methods of ​Set from ​main
 * when needed.
 *
 * For more information about how to implement generic classes, see the book (9th edition p. 920 / 10th edition p. 884).
 *
 * Input format:
 *  ● Integer ​N - number of people you want to invite.
 *  ● On following ​N lines: single string per line - the names of the people you want to invite (all lowercase, no
 *  spaces). Some of the names may repeat.
 *  ● Integer ​Q - number of people you want to uninvite.
 *  ● On following ​Q lines: single string per line - the names of the people you want to uninvite (all lowercase, no
 *  spaces). Some of the names may repeat.
 *  ● Single string ​S - name of the person your friend asked about.
 *
 * Output format
 *
 *  ● First line: ​integer - number of people that are still invited to the party, after you have performed the
 *  invitations and un-invitations.
 *  ● Second line: ​true/false depending on whether person ​S is on the list, after you have invited and uninvited people.
 */


class Solution {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        Set <String> set = new Set<>();

        int names1 = scanner.nextInt();
        for(int index = 0; index < names1; index ++){
            set.add(scanner.next());
        }
        int names2 = scanner.nextInt();
        for(int index = 0; index < names2; index ++){
            set.remove(scanner.next());
        }
        boolean s = set.contains(scanner.next());

        System.out.print(set.size()+ "\n");
        System.out.print(s);

    }
}
class Set <E extends String>{
    private LinkedList <E> linkedList = new LinkedList<>();

    public boolean add(E o){
        if(o == null){
            throw new NullPointerException();
        }
        if(contains(o)){
            return false;
        }else{
            linkedList.addLast(o);
            return true;
        }
    }

    public boolean contains(E o){
        if(o == null){
            throw new NullPointerException();
        }
        return linkedList.contains(o);
    }

    public boolean remove(E o){
        if(o == null){
            throw new NullPointerException();
        }
        if(contains(o)){
            linkedList.remove(o);
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return linkedList.size();
    }
}

