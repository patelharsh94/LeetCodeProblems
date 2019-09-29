import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
// 1046. Last Stone Weight
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 0)
            return 0;

        List<Integer> stonesList = Arrays.stream(stones).boxed().collect(Collectors.toList());
        stonesList.sort(Comparator.reverseOrder());

        while (stonesList.size() > 1) {
            for (int i = 0; i < 1; i++) {
                int x = stonesList.get(i+1);
                int y = stonesList.get(i);

                if (x == y) {
                    stonesList.remove(i+1);
                    stonesList.remove(i);
                } else {
                    stonesList.remove(i+1);
                    stonesList.set(i, y-x);
                    stonesList.sort(Comparator.reverseOrder());
                }
            }
        }

        return stonesList.size() > 0 ? stonesList.get(0) : 0;
    }

}
