package Amazon;

import org.junit.Test;

import java.util.*;

public class Demo {

    public List<Integer> cellCompete(int[] states, int days)
    {
        int secondValue = states[1];
        int secondToLastValue = states[states.length - 2];
        int prev = states[0];
        int curr;

        // deepCopyState(states, prevState);
        List<Integer> finalStates = new ArrayList<>();

        while (days > 0) {
            for (int i = 1; i <= states.length - 2; i++) {
                curr = states[i];
                states[i] = prev ^ states[i+1];
                prev = curr;
            }

            states[0] = secondValue;
            states[states.length - 1] = secondToLastValue;

            secondValue = states[1];
            secondToLastValue = states[states.length - 2];
            prev = states[0];
            days--;
        }

        for (int i : states) {
            finalStates.add(i);
        }

        return finalStates;
    }

    @Test
    public void test() {
        int [] states = new int [] {1, 0, 0, 0, 0, 1, 0, 0};
        List<Integer> result = cellCompete(states, 1);

        System.out.println(result);
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int min = Integer.MAX_VALUE;

        if (num == 0)
            return -1;

        for (int i : arr) {
            if (i < min)
                min = i;
        }

        while (min > 0) {

            if(isGCD(arr, min))
                return min;

            min--;
        }

        return -1;
    }

    private boolean isGCD(int [] arr, int divisor) {

        for (int i : arr) {
            if (i % divisor != 0)
                return false;
        }

        return true;
    }

    @Test
    public void test2() {
        int [] arr1 = {2, 4, 6, 8, 10};
        System.out.println(generalizedGCD(arr1.length, arr1));
    }

}
