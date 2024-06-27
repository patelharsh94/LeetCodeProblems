import org.junit.Test;

public class RemoveDuplicates {

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates2(int[] nums) {
        int aPtr = 0;
        int bPtr = 1;

        while (bPtr < nums.length) {

            if (nums[aPtr] == nums[bPtr]) {
                bPtr++;
            } else {
                aPtr++;
                nums[aPtr] = nums[bPtr];
            }

        }

        return aPtr+1;
    }

    @Test
    public void testRemoveDuplicates2() {
        int [] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates2(arr);
    }
}
