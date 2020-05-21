package Mocks;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Mock13 {

    public int removeElement(int[] nums, int val) {

        int j = 0;
        int removeCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                nums[i] = Integer.MIN_VALUE;
                removeCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                j = i;

                for (int a = i; a < nums.length; a++) {
                    if (nums[a] != Integer.MIN_VALUE) {
                        nums[j] = nums[a];
                        nums[a] = Integer.MIN_VALUE;
                        j++;
                    }
                }
            }
        }


        return nums.length - removeCount;
    }

    @Test
    public void test() {
        int [] arr = {0,1,2,2,3,0,4,2};
        assertEquals(removeElement(arr, 2), 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        findCombos(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public void findCombos(List<List<Integer>> results, List<Integer> currList, int [] candidates, int target, int index) {

        if (target == 0) {
            results.add(new ArrayList<>(currList));
        } else if (target > 0) {

            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                currList.add(candidates[i]);
                findCombos(results, currList, candidates, target - candidates[i], i);
                currList.remove(currList.size() - 1);
            }
        }

    }

    @Test
    public void test2() {
        int [] candidates = {7, 3, 2};
        int target = 18;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
