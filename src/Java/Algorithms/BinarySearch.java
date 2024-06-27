package Algorithms;

import org.junit.Test;

public class BinarySearch {

    public int binTest(int x, int [] data) {
        int start = 0;
        int end = data.length;
        int mid = (end+start)/2;

        while (start < end) {

            if (data[mid] == x) {
                return mid;
            }

            if (data[mid] < x) {
                start = mid + 1;
            } else {
                end = mid;
            }

            mid = (end + start)/2;

        }
    }


    public int binarySearchRecursive (int x, int [] data) {
        return binarySearchRec(0, data.length, data, x);
    }

    public int binarySearchRec (int start, int end, int [] data, int val) {

        int mid = (start+end)/2;

        if (start >= end)
            return -1;
        else if (data[mid] == val)
            return mid;
        else if (data[mid] < val)
            return binarySearchRec(mid+1, end, data, val);
        else
            return binarySearchRec(start, mid, data, val);
    }

    @Test
    public void test() {
        int [] data = new int[] {6, 7, 12, 14, 15, 23, 32, 37, 39};

        int index = binarySearchIterative(12, data);

        System.out.println(index);
    }
}
