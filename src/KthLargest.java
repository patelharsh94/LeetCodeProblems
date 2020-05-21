import java.util.Arrays;

public class KthLargest {

    // 215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
