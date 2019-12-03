package BloombergPractice;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1029. Two City Scheduling

class CityCosts {

    int difference = 0;
    int a;
    int b;

    CityCosts (int a, int b) {
        this.a = a;
        this.b = b;
        difference = a - b;
    }

}

public class TwoCitySchedulingCost {

    public int twoCitySchedCost(int[][] costs) {

        List<CityCosts> costsList = new ArrayList<>();
        int total = 0;
        int n = costs.length;

        for (int [] cost : costs) {
            costsList.add(new CityCosts(cost[0], cost[1]));
        }

        costsList.sort(Comparator.comparingInt(value -> value.difference));

        for (int i = 0; i < n; i++) {

            if (i < n/2) {
                total += costsList.get(i).a;
            } else {
                total += costsList.get(i).b;
            }
        }

        return  total;
    }
}
