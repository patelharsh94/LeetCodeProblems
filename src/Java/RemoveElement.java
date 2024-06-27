import org.junit.Test;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int totalVals = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                totalVals++;
        }

        int j = 0;
        int tailIndex = nums.length - 1;

        while (j < nums.length - totalVals) {

            if (nums[j] == val) {

                while (nums[j] == nums[tailIndex]) {
                    tailIndex--;
                }

                nums[j] = nums[tailIndex];
                nums[tailIndex] = val;
            }

            j++;
        }

        return nums.length - totalVals;
    }

    @Test
    public void test() {

        int [] nums = new int [] {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(RemoveElement.removeElement(nums, 2));

    }
}
