package Mocks;

import org.junit.Test;

import java.util.ArrayList;

public class Mock34 {

    public int rotatedDigits(int N) {

        int res =  0;

        for (int i = 1; i <= N; i++) {
            String curNum = String.valueOf(i);

            if (isGood(curNum)) {
                res++;
            }

        }

        return res;
    }

    public boolean isGood(String curNum) {
        ArrayList<Integer> rotatedValues = new ArrayList<>();
        rotatedValues.add(2);
        rotatedValues.add(5);
        rotatedValues.add(6);
        rotatedValues.add(9);

        ArrayList<Integer> userlessValues = new ArrayList<>();
        userlessValues.add(0);
        userlessValues.add(1);
        userlessValues.add(8);
        boolean isG = false;
        for (int i = 0; i < curNum.length(); i++) {

            if (rotatedValues.contains(curNum.charAt(i) - '0')) {
                isG = true;
            } else if (userlessValues.contains(curNum.charAt(i) - '0')) {
                continue;
            } else {
                return false;
            }
        }

        return isG;
    }

    public int maxDistToClosest(int[] seats) {

        int l = 0; int r = 1;
        int maxDistance = -1;

        if (seats.length <= 1) {
            return 0;
        }

        while (r < seats.length) {

            if (seats[r] == 0) {
                r++;
            } else {

                if (seats[l] == 0) {
                    maxDistance = r - l;
                } else {
                    maxDistance = Math.max(maxDistance,(int) ((r-l)/2.0));
                }
                l = r;
                r += 1;
            }
        }

        if (seats[r-1] == 0) {
            maxDistance = Math.max(r - l - 1, maxDistance);
        }
        return maxDistance;
    }



}
