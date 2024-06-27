import java.util.Arrays;

// 80. Remove Duplicates from Sorted Array II

public class RemoveDuplicatesSortedArray {
    
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int currNum = 0;
        int finalLength = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                currNum++;
            } else {
                currNum = 0;
            }

            if (currNum > 1) {
                int j = i;
                int lasNum = nums[j];
                while (j < nums.length && nums[j] == lasNum) {
                    nums[j] = Integer.MAX_VALUE;
                    j++;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != Integer.MAX_VALUE) {
                finalLength++;
            }
        }

        Arrays.sort(nums);
        return finalLength;
    }


}
