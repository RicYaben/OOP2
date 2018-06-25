package Week_4;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class W4P2 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        LinkedList <String> linkedList = new LinkedList<>();
        for(int index = length; index >= 1; index --){
            linkedList.add(scanner.nextLine());
        }
        for(String aString : linkedList){
            System.out.print(result(aString) + "\n");
        }
    }
    private static String result(String string){

        Stack<Character> stack = new Stack<>();

        for(int index = 0; index < string.length(); index ++){
            char ch = string.charAt(index);

            if(ch == '(' || ch == '{' || ch == '[' || ch == '<'){
                stack.push(ch);
            }else if((ch == ')' || ch == '}' || ch == ']' || ch == '>') && (!stack.isEmpty())){
                if (((stack.peek() == '(' && ch == ')')
                        || stack.peek() == '{' && ch == '}'
                        || stack.peek() == '[' && ch == ']'
                        || stack.peek() == '<' && ch == '>')){

                    stack.pop();
                }else {
                    return "false";
                }
            }else if(ch == ')' || ch == '}' || ch == ']' || ch == '>'){
                return "false";
            }
        }
        if(stack.isEmpty()){
            return "true";
        }else{
            return "false";
        }
    }
}
