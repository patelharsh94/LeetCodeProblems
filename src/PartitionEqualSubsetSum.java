import java.util.*;

// 416. Partition Equal Subset Sum
// Solution from: https://www.youtube.com/watch?v=3N47yKRDed0

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        int firstBucketSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum < 2 || totalSum % 2 != 0)
            return false;

        return canPartitionRecurse(nums, 0, 0, totalSum, new HashMap<>());
    }


    private boolean canPartitionRecurse(int [] nums, int index, int sum, int total, HashMap<String, Boolean> state) {

        String currentState = index + "" + sum;

        if (state.containsKey(currentState))
            return state.get(currentState);

        if (sum * 2 == total)
            return true;

        if (index >= nums.length || sum > total/2)
            return false;

        boolean foundPartition = canPartitionRecurse(nums, index + 1, sum, total, state) || canPartitionRecurse(nums, index + 1, sum + nums[index], total, state);

        state.put(currentState, foundPartition);

        return foundPartition;
    }
}
