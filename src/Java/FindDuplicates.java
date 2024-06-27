import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;

            if (nums[index] < 0) {
                results.add(index+1);
            }

            nums[index] *= -1;
        }

        return results;
    }

}
