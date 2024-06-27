public class MissingNumber {

    // 268. Missing Number
    public int missingNumber(int[] nums) {
        nums[0] = nums[0] - 1;
        for (int i = 2; i <= nums.length; i++) {
            nums[i - 1] += nums[i - 2] - i;
        }

        return nums.length > 1 ? Math.abs(nums[nums.length - 1]) : Math.abs(nums[0]);
    }

}
