import java.util.Random;

// 384. Shuffle an Array

public class ShuffelCards {

    int[] nums;
    int[] ogNums;

    public ShuffelCards(int[] nums) {
        this.nums = new int[nums.length];
        this.ogNums = new int[nums.length];

        System.arraycopy(nums, 0, this.nums, 0, this.nums.length);
        System.arraycopy(nums, 0, this.ogNums, 0, this.nums.length);

    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        if (nums.length > 0) {
            System.arraycopy(this.ogNums, 0, this.nums, 0, this.nums.length);
        }
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();

        if (this.nums.length > 0) {

            for (int i = 0; i < this.nums.length; i++) {
                int newRandomNum = random.nextInt(this.nums.length);
                int temp = this.nums[i];
                this.nums[i] = this.nums[newRandomNum];
                this.nums[newRandomNum] = temp;
            }

        }

        return this.nums;
    }
}
