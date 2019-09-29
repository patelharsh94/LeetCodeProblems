package DataStructuresAndAlgoImplementations;

public class BinarySearch {

    public int binarySearchIterative (int x, int [] data) {

        int mid = data.length/2;
        int start = 0;
        int end = data.length;

        while (start < end) {

            if (data[mid] == x) {
                return mid;
            } else if (x > data[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = (end + start) / 2;
        }

        return -1;
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
}
