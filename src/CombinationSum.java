import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. Combination Sum
public class CombinationSum {
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
}
