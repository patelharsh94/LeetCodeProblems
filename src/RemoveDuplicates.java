public class RemoveDuplicates {

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {

        int dups = 0;

        for (int i = 0; i < nums.length - 1; i ++) {

            if (nums[i] == nums[i+1]) {
                dups++;
            } else {
                nums[i-dups+1] = nums[i+1];
            }

        }

        return nums.length - dups;
    }

}
