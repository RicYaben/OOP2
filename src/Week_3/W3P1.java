package Week_3;
import java.util.Scanner;

/**
* Week 3 – Problem 1
* Write a program that reads some integers. The first integer n, represents the total number of following integers.
* Sort the integers (excluding the first) with three different algorithms: Merge sort, Insertion sort and Selection sort. Measure the time it takes for each algorithm to complete the sort (use System.nanoTime() to measure the execution time of the method).
* The output consists of two lines:
* • Line 1 is composed of the first 10 integers of the sorted integers
* • Line 2 is the name of the fastest algorithm.
**/

public class W3P1 {
    public static void main(String[]arg){
        Scanner scanner = new Scanner(System.in);

        int lengthArr = scanner.nextInt();

        int[] mergeSortArr = new int[lengthArr];
        int[] insertionSortArr = new int[lengthArr];
        int[] selectionSortArr = new int[lengthArr];

        for(int x = 0; x < mergeSortArr.length; x++){
            int number = scanner.nextInt();
            mergeSortArr[x] = number;
            insertionSortArr[x] = number;
            selectionSortArr[x] = number;
        }
        long mergeTime = mergeSort(mergeSortArr);
        long insertionTime = insertionSort(insertionSortArr);
        long selectionTime = selectionSort(selectionSortArr);

        for(int x = 0; x < 10; x++){
            System.out.print(mergeSortArr[x]+ " ");
        }
        if(mergeTime < insertionTime && selectionTime > mergeTime){
            System.out.print("\nMerge sort");
        }else if(insertionTime < mergeTime && insertionTime < selectionTime){
            System.out.print("\nInsertion sort");
        }else{
            System.out.print("\nSelection sort");
        }
        /*System.out.print("\n" + "Merge: " + mergeTime + "\n" + "Insertion: " + insertionTime + "\n" + "Selection: " + selectionTime+ "\n");*/
    }

    private static long mergeSort(int[] array){
        long start = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        return System.nanoTime() - start;
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle1 = start + (end - start) / 2;
        int middle2 = middle1 + 1;

        mergeSort(array, start, middle1);
        mergeSort(array, middle2, end);

        merge(array, start, middle1, middle2, end);
    }

    private static void merge(int[] array, int start, int middle1, int middle2, int end) {
        int i = start;
        int j = middle2;

        int[] temp = new int[end - start + 1];
        int curr = 0;

        while (i <= middle1 && j <= end) {
            if (array[i] < array[j]) {
                temp[curr] = array[i];
                i++;
            } else {
                temp[curr] = array[j];
                j++;
            }
            curr++;
        }
        if (i > middle1) {
            for (int k = j; k <= end; k++) {
                temp[curr] = array[k];
                curr++;
            }
        } else if (j > end) {
            for (int k = i; k <= middle1; k++) {
                temp[curr] = array[k];
                curr++;
            }
        }
        System.arraycopy(temp, 0, array, start, temp.length);
    }

    private static long insertionSort(int[] array){
        long start = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                swap(array, j, j - 1);
            }
        }
        return System.nanoTime() - start;
    }

    private static long selectionSort(int[] array){
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return System.nanoTime() - start;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
