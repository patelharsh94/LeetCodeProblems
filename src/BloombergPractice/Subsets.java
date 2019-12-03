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
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        System.out.println(numList);

        for (int i = 0; i < nums.length; i++) {

            List<Integer> currSet = new ArrayList<>();

            for (int j = i+1; j < nums.length - i; j++) {
                currSet.addAll(numList.subList(i, j));
            }

            subsets.add(currSet);
            currSet = new ArrayList<>();
        }

        System.out.println(subsets);

        return subsets;
    }

}
