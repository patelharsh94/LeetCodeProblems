import java.util.ArrayList;
import java.util.List;

public class OptimalUtilization {

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        List<List<Integer>> finalCapacity = new ArrayList<>();
        int maxCapacity = 0;

        for (int i = 0; i < foregroundAppList.size(); i++) {

            for (int j = 0; j < backgroundAppList.size(); j++) {
                int currCap = foregroundAppList.get(i).get(1) + backgroundAppList.get(j).get(1);
                if (currCap <= deviceCapacity && currCap >= maxCapacity) {
                    if (currCap > maxCapacity)
                        finalCapacity = new ArrayList<>();

                    maxCapacity = currCap;

                    List<Integer> ids = new ArrayList<>();
                    ids.add(foregroundAppList.get(i).get(0));
                    ids.add(backgroundAppList.get(j).get(0));
                    finalCapacity.add(ids);
                }
            }
        }

        return finalCapacity;
    }

}
