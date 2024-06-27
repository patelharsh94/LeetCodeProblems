package Mocks;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Mock4 {

    /*
    * Given an array of 4 digits, return the largest 24 hour time that can be made. The smallest 24 hour time is 00:00,
    * and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
    * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
    * */

    public String largestTimeFromDigits(int[] A) {

        int maxTime = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 2) {
                for (int j = 0; j < A.length; j++) {
                    if (j != i) {
                        for (int k = 0; k < A.length; k++) {
                            if (k != i && k != j) {
                                for (int l = 0; l < A.length; l++) {
                                    if (l != i && l != j && l != k) {
                                        int currHr = A[i] * 10 + A[j];
                                        int currMin =  A[k] * 10 + A[l];
                                        if (currHr < 24 && currMin < 60) {
                                            maxTime = Math.max(maxTime, currHr*60 + currMin);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxTime  != -1 ? String.format("%02d:%02d", maxTime / 60, maxTime % 60) : "";
    }

    @Test
    public void testLargestTimeFromDigits() {
        assertEquals(largestTimeFromDigits(new int [] {1, 2, 3, 4}), "23:41");
        assertEquals(largestTimeFromDigits(new int [] {5, 5, 5, 5}), "");
        assertEquals(largestTimeFromDigits(new int [] {0, 0, 0, 0}), "00:00");
    }
}
