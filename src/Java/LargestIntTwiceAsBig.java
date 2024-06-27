// #747. Largest Number At Least Twice of Others
public class LargestIntTwiceAsBig {
    public int dominantIndex(int[] nums) {

        int largest = Integer.MIN_VALUE + 1;
        int secondLargest = Integer.MIN_VALUE;
        int largestIndex = 0;

        if (nums.length == 1)
            return 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                largestIndex = i;
            }
        }

        return  largest >= secondLargest*2 ? largestIndex : -1;
    }
}
