// 1122. Relative Sort Array
public class RelativeSortArr {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int [] countArr = new int [1001];
        int j = 0;

        for (int i : arr1) {
            countArr[i]++;
        }

        for (int i = 0; i < arr2.length; i++) {

            while (countArr[arr2[i]] > 0) {
                arr1[j] = arr2[i];
                countArr[arr2[i]]--;
                j++;
            }
        }

        for (int i = 0; i < 1001; i++) {

            while (countArr[i] > 0) {
                arr1[j] = i;
                j++;
                countArr[i]--;
            }

        }

        return arr1;
    }
}
