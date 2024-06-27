package BloombergPractice;

// 78. Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.


import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        subsets = getSubsetsRecurse(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    public List<List<Integer>> getSubsetsRecurse(List<List<Integer>> totalSubsets, List<Integer> currSubset, int[] nums, int index) {

        List<Integer> newSubset = new ArrayList<>();
        newSubset.addAll(currSubset);

        while (index < nums.length) {
            newSubset.add(nums[index]);
            totalSubsets.add(newSubset);
            getSubsetsRecurse(totalSubsets, newSubset, nums, index+1);
            newSubset = new ArrayList<>();
            newSubset.addAll(currSubset);
            index++;
        }

        return totalSubsets;
    }

}
