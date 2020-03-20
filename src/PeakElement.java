public class PeakElement {

    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1])
            return 0;

        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        return 0;
    }

}
