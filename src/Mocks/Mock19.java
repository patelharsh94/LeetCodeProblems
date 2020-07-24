package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock19 {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permuteList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        List<Integer> leftOverList = new ArrayList<>();

        for (int i : nums)
            leftOverList.add(i);

        permuteHelper(permuteList, currList, leftOverList, nums.length);

        System.out.println(permuteList);
        return permuteList;
    }

    public void permuteHelper(List<List<Integer>> permuteList, List<Integer> currentList, List<Integer> leftoverList, int finalSize) {

        if (leftoverList.size() == 0) {
            permuteList.add(currentList);
            return;
        }

        for (int i = 0; i < finalSize; i++) {
            currentList.add(leftoverList.get(i));
            permuteHelper(permuteList, currentList, leftoverList, finalSize);
        }
    }

    @Test
    public void test() {
        permute(new int [] {1, 2, 3});
    }
}


