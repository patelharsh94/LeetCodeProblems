package easy;

import org.junit.Test;

public class Arrays {

    /*
    * Given an array nums, write a function to move all 0's to the end of it while maintaining the
    * relative order of the non-zero elements.
    * */
    public void moveZeroes(int[] nums) {
        int numOfZero = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZero++;
            }
        }
        int [] newArr = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (j < newArr.length && nums[i] != 0) {
                newArr[j] = nums[i];
                j++;
            }
        }

        nums = newArr;
    }

    @Test
    public void runMoveZero() {
        moveZeroes(new int [] {0, 1, 0, 3, 12});
    }

}