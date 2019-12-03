import BloombergPractice.RandomizedSet;
import BloombergPractice.Subsets;
import BloombergPractice.TwoCitySchedulingCost;

public class Main {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        TwoCitySchedulingCost twoCitySchedulingCost = new TwoCitySchedulingCost();
        twoCitySchedulingCost.twoCitySchedCost(costs);

    }
}
