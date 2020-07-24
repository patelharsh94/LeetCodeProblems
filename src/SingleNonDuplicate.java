public class SingleNonDuplicate {

    // 540. Single Element in a Sorted Array
    public int singleNonDuplicate(int[] nums) {

        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i+=2) {
                if (i + 1 >= nums.length || nums[i] != nums[i+1])
                    return nums[i];
            }
        }


        return nums[0];
    }

}
