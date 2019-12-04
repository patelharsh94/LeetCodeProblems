import BloombergPractice.RandomizedSet;
import BloombergPractice.Subsets;
import BloombergPractice.TwoCitySchedulingCost;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] set = new int[] {1, 2, 3};

        Subsets subsets = new Subsets();
        List<List<Integer>> subsetList = subsets.subsets(set);
        System.out.println(subsetList);
    }
}
