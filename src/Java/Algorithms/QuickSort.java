package Algorithms;

import org.junit.Test;

public class QuickSort {

    public void quickSort(int [] arr) {
        sort(arr, 0, arr.length-1);
    }

    public void sort (int [] arr, int start, int end) {

        if (start <= end) {

            int pivot = partition(arr, start, end);

            sort(arr, start, pivot-1);
            sort(arr, pivot+1, end);
        }

    }

    public int partition(int [] arr, int min, int max) {

        int pivot = arr[max];
        int i = min - 1;
        int temp;

        for (int j = min; j < max; j++) {

            if (arr[j] < pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;

        temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;

        return i;
    }

    @Test
    public void test() {
        int [] arr = {1,5,2,4,7,8,12};

        quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
