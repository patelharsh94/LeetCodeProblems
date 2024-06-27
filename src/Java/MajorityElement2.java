import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

// 229. Majority Element II

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int third = nums.length / 3;
        int total = 0;
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(nums);
        int currTotal = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] != nums[i-1] && currTotal > third) {
                result.add(nums[i-1]);
                currTotal = 0;
            }

            if (i > 0 && nums[i] != nums[i-1]) {
                currTotal = 0;
            }

            currTotal++;
        }
        if (currTotal > third && !result.contains(nums[nums.length - 1]))
            result.add(nums[nums.length - 1]);

        return result;
    }

    @Test
    public void test() {
        int [] input = new int [] {3,2,3};
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        assertEquals(majorityElement(input), expected);
    }

}
