import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 1187. Make Array Strictly Increasing
public class MakeArraysStrictlyIncreasing {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int total = 0;

        if (!isIncreasing(arr1)) {
            int i = 0;
            int num;

            for (i = 0; i < arr1.length - 2; i++) {

                if (arr1[i] > arr1[i + 1]) {
                    if (i > 0) {
                        num = findMiddleInt(arr1[i - 1], arr1[i + 1], arr2);
                    } else {
                        num = findMiddleInt(-1, arr1[i], arr2);
                    }
                    if (num != -1) {
                        arr1[i] = num;
                        total++;
                    } else {
                        return -1;
                    }
                }

                if (arr1[i] == arr1[i + 1]) {
                    num = findMiddleInt(arr1[i], arr1[i + 2], arr2);
                    if (num != -1) {
                        arr1[i+1] = num;
                        total++;
                    } else {
                        return -1;
                    }
                }
            }

            if (arr1[arr1.length - 2] == arr1[arr1.length -1]) {
                num = findMiddleInt(arr1[arr1.length-1], Integer.MAX_VALUE, arr2);

                if (num != -1) {
                    arr1[arr1.length - 1] = num;
                    total++;
                } else {
                    return -1;
                }
            }
        }

        return total;
    }

    public int findMiddleInt(int a, int b, int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > a && arr[i] < b) {
                return arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > a && arr[i] <= b) {
                return arr[i];
            }
        }
        return -1;
    }

    public boolean isIncreasing(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1])
                return false;
        }

        return true;
    }

    @Test
    public void test() {

        int [] arr1 = {1,5,3,6,7};
        int [] arr2 = {1,3,2,4};

        assertEquals(makeArrayIncreasing(arr1, arr2), 1);

    }
}
