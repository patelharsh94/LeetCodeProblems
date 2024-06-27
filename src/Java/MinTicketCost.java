import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 983. Minimum Cost For Tickets
public class MinTicketCost {

    public int mincostTickets(int[] days, int[] costs) {

        int totalCost = 0;
        int i = 0;

        while(i < days.length) {

            double indexAfterSevenDayPass = costOfChoice(days, i+1, 7);
            double indexAfterThirtyDayPass = costOfChoice(days, i+1, 30);

            double oneDayCost = .5;
            double sevenDayCost = 1 - (indexAfterSevenDayPass/7);
            double thirtyDayCost = 1 - (indexAfterThirtyDayPass/30);

            if (oneDayCost < sevenDayCost && oneDayCost < thirtyDayCost) {
                i++;
                totalCost += costs[0];
            }

            if (sevenDayCost < oneDayCost && sevenDayCost < thirtyDayCost) {
                i += indexAfterSevenDayPass;
                totalCost += costs[1];
            }

            if (thirtyDayCost < sevenDayCost && thirtyDayCost < oneDayCost) {
                i += indexAfterThirtyDayPass;
                totalCost += costs[2];
            }
        }

        return totalCost;
    }


    private double costOfChoice(int [] days, int index, int numOfDays) {

        double daysCovered = 0;

        for (int i = index; i <= numOfDays && i < days.length; i++) {
            if (days[i] - days[index] <= numOfDays) {
                daysCovered++;
            }
        }

        return daysCovered;
    }

    @Test
    public void test() {
        int [] days1 = {1,4,6,7,8,20};
        int [] days2 = {1,2,3,4,5,6,7,8,9,10,30,31};
        int [] days3 = {6,8,9,18,20,21,23,25};
        int [] days4 = {3,4,7,8,9,11,12,18,19,20,24,27};
        int [] cost = {2, 7, 15};
        int [] cost2 = {2,10,41};
        int [] cost3 = {2,12,52};

        //assertEquals(mincostTickets(days1, cost), 11);
        //assertEquals(mincostTickets(days2, cost), 17);
        //assertEquals(mincostTickets(days3, cost2), 16);
        assertEquals(mincostTickets(days4, cost3), 24);
    }

}


