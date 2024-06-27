package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock16 {

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            if (nums[i] <= target && nums[i + 1] >= target)
                return i + 1;
        }

        return start;
    }
}
