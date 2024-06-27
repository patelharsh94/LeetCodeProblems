
// 40. Combination Sum II

import org.junit.Test;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        getCombinations(result, new ArrayList<>(), candidates, 0,  target);

        return result;
    }

    public void getCombinations(List<List<Integer>> results,  List<Integer> currList, int [] candidates, int index, int target) {

        if (target == 0) {

            results.add(new ArrayList<>(currList));

        } else if (target > 0){

            for (int i = index; i < candidates.length; i++) {

                if ( i == index || candidates[i] != candidates[i-1]) {
                    currList.add(candidates[i]);
                    getCombinations(results, currList, candidates, i+1, target - candidates[i]);
                    currList.remove(currList.size() - 1);
                }

            }
        }

    }

    @Test
    public void test() {
        int [] arr = new int [] {10, 1, 2, 7, 6, 1, 5};
        System.out.println((combinationSum2(arr, 8)));
    }

}
