package Mocks;

import org.junit.Test;

import java.util.Arrays;

public class Mock21 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA != null && headB != null) {
            int nullCount = 0;
            ListNode runnerA = headA;
            ListNode runnerB = headB;

            while (nullCount <= 2) {

                if (runnerA == runnerB)
                    return runnerA;

                runnerA = runnerA.next;
                runnerB = runnerB.next;

                if (runnerA == null) {
                    runnerA = headB;
                    nullCount++;
                }

                if (runnerB == null) {
                    runnerB = headA;
                    nullCount++;
                }
            }
        }

        return null;
    }


    @Test
    public void test1() {

        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(3);
        ListNode commonNode = new ListNode(4);
        commonNode.next = new ListNode(5);
        commonNode.next = new ListNode(6);
        ListNode listB = new ListNode(8);
        listB.next = new ListNode(9);

        listA.next.next.next = commonNode;
        listB.next.next = commonNode;

        System.out.println(getIntersectionNode(listA, listB).val);

    }


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaT1 = (C-A) * (D-B);
        int areaT2 = (G-E) * (H-F);

        // special case 1
        if (A == E && B == F && C == G && D == H) {
            return areaT1;
        }

        // special case 2
        if (A < E && E < C && F < B && H < D) {
            return areaT1 + areaT2 - ((Math.abs(C)-Math.abs(E)) *  (Math.abs(D)-Math.abs(H)));
        }

        // special case 3
        if (A < E && B < F && C > G && D > H) {
            return Math.max(areaT1, areaT2);
        }

        return areaT1 + areaT2;
    }

    @Test
    public void test2() {
        System.out.println(computeArea(-2, -2, 2, 2, 1, -3, 3, -1));
    }

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int total = 0;
        int numCoins = 0;

        for (int i = coins.length-1; i >= 0; i--) {

            while (total < amount) {
                total+= coins[i];
                numCoins ++;
            }

            if (total > amount) {
                total -= coins[i];
                numCoins--;
            }

            if (total == amount)
                return numCoins;
        }

        return -1;

    }
}
