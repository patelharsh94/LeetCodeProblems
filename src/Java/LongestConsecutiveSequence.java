import java.util.HashSet;
// 128. Longest Consecutive Sequence
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numsSet = new HashSet<>();
        int max = 0;
        int seqSize;

        for (int i = 0; i < nums.length; i++)
            numsSet.add(nums[i]);


        for (int i = 0; i < nums.length; i++) {
            seqSize = 1;
            numsSet.remove(nums[i]);

            int low = nums[i];
            int high = nums[i];

            while (numsSet.contains(--low)) {
                numsSet.remove(low);
                seqSize++;
            }

            while (numsSet.contains(++high)) {
                numsSet.remove(high);
                seqSize++;
            }

            if (seqSize > max)
                max = seqSize;
        }

        return max;
    }
}
