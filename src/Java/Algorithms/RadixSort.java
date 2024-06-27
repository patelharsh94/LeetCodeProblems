package Algorithms;

import org.junit.Test;

import java.util.Arrays;

public class RadixSort {

    public int [] radixSort(int [] arr) {

        // find max to get exp
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 1; max/i > 0; i*=10 ) {
            countingSort(arr, i);
        }

        return arr;
    }

    public int [] countingSort(int [] arr, int exp) {

        int [] countSortArr = new int [10];
        int [] outputArr = new int [arr.length];
        Arrays.fill(countSortArr, 0);

        // getting num occurrences
        for (int i = 0; i < arr.length; i++) {
            countSortArr[(arr[i] / exp)%10]++;
        }

        // adding
        for (int i = 1; i < 10; i++) {
            countSortArr[i] += countSortArr[i-1];
        }

        // re sort
        for (int i = arr.length - 1; i >= 0; i--) {
            outputArr[countSortArr[(arr[i] / exp)%10]-1] = arr[i];
            countSortArr[(arr[i] / exp)%10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = outputArr[i];
        }

        return arr;
    }

    private void printArr(int [] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int [] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        arr = radixSort(arr);
        printArr(arr);
    }

}
