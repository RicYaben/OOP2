package Week_3;
import java.util.Arrays;
import java.util.Scanner;

public class W3P2 {

    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        int[] arraySorted = new int[array.length];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
            arraySorted[i] = array[i];
        }

        int[] keys = new int[scanner.nextInt()];
        for(int j = 0; j < keys.length; j++){
            keys[j] = scanner.nextInt();
        }

        Arrays.sort(arraySorted);

        if(Arrays.equals(array, arraySorted)) {
            for (int key : keys) {
                int []linear = linearSearch(array, key);
                int []binary = binarySearch(array, key);
                if (linear[1] < binary[1]){
                    System.out.print("Linear search: " + linear[0] + "\n");
                } else if (linear[1] == binary[1]) {
                    System.out.print("Linear search: " + linear[0] + "\n");
                } else {
                    System.out.print("Binary search: " + linear[0] + "\n");
                }
            }
        }else{
            for (int key : keys) {
                int []linear = linearSearch(array, key);
                System.out.print("Linear search: " + linear[0] + "\n");
            }
        }
    }
    private static int[] linearSearch(int[] data, int key ){
        int[] a = new int[2];
        int compis = 0;
        for(int index = 0; index < data.length; index++){
            if(data[index] == key){
                a[0] = index +1;
                a[1] = compis;
                return a;
            }
            compis ++;
        }
        a[0] = -1;
        a[1] = compis;
        return a;
    }
    private static int[] binarySearch(int[] data, int key){

        int location = -1;
        int high = data.length -1;
        int low = 0;
        int middle = (low + high + 1) / 2;
        int comp = 0;
        int[] a = new int[2];

        do{
            if (key == data[middle]){
                a[0] = middle +1;
                return a;
            }else if(key < data[middle]){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
            middle = (low + high + 1)/2;
            comp ++;
        } while(low <= high);

        a[0] = location;
        a[1] = comp;
        return a;
    }
}
