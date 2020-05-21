package Algorithms;

public class MergeSort {


    public MergeSort() {}

    public void mergeSort(int [] data) {

        if (data.length > 1) {

            int [] rhs = new int [data.length/2];
            int [] lhs = new int [data.length/2];

            int i = 0;

            while (i < rhs.length) {
                lhs[i] = data[i];
                i++;
            }

            int j = 0;
            while (j < lhs.length) {
                rhs[j] = data[i];
                i++;
                j++;
            }

            mergeSort(rhs);
            mergeSort(lhs);
            data = merge(rhs, lhs);

        }

    }

    public int [] merge(int [] lhs, int [] rhs) {

        int [] finalArr = new int [lhs.length + rhs.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lhs.length && j < rhs.length) {

            if (lhs[i] < rhs[j]) {
                finalArr[k] = lhs[i];
                i++;
            } else {
                finalArr[k] = rhs[j];
                j++;
            }

            k++;
        }

        while (i < lhs.length) {
            finalArr[k] = lhs[i];
            i++;
            k++;
        }

        while (j < rhs.length) {
            finalArr[k] = rhs[j];
            j++;
            k++;
        }

        return finalArr;
    }
}


