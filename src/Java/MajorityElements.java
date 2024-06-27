import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElements {

    // 169. Majority Element
    public int majorityElement(int[] nums) {

        int thresh = nums.length / 2;
        AtomicInteger result = new AtomicInteger();

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (counts.containsKey(nums[i])) {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            } else {
                counts.put(nums[i], 1);
            }
        }

        counts.forEach((k,v) -> {

            if (v > thresh) {
                result.set(k);
            }
        });

        return result.get();
    }

    @Test
    public void test( ) {
        majorityElement(new int [] {2,2,1,1,1,2,2});
    }
}
