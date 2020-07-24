package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock26 {

    public int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        int mid = (start + end) / 2;

        while (start < end) {

            if (isBadVersion(mid)) {

                if (mid > 1 && !isBadVersion(mid-1))
                    return mid;
                else if (mid == 1)
                    return 1;

                end = mid;
            } else {
                start = mid+1;
            }
            mid = (start + end) / 2;
        }

        return isBadVersion(mid) ? mid : n;
    }

    public boolean isBadVersion(int ver) {
        return ver >= 1;
    }

    @Test
    public void test() {
        firstBadVersion(3);
    }
}

class SnapshotArray {

    int [] arr;
    int [] prevArr;
    int snapId = 0;
    HashMap<Integer, int []> snapHash = new HashMap<>();

    public SnapshotArray(int length) {
        arr = new int [length];
        prevArr = new int [length];
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {

        snapHash.put(snapId, Arrays.copyOf(arr, arr.length));
        snapId++;
        return snapId;
    }

    public int get(int index, int snap_id) {
        return snapHash.get(snap_id)[index];
    }
}

