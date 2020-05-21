package Mocks;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Mock11 {

    public boolean rotateString(String A, String B) {

        if (A != null && B != null && !A.equals(B) && A.length() == B.length()) {

            for (int i = 0; i < A.length(); i++) {
                String newStr = A.substring(1, A.length()) + A.substring(0,1);
                if (newStr.equals(B))
                    return  true;
                else
                    A = newStr;
            }
        }

        return false;
    }

    @Test
    public void testRotateString() {
        // assertTrue(rotateString("abcde", "cdeab"));
        assertFalse(rotateString("", ""));
    }

    public List<Integer> majorityElement(int[] nums) {

        int tresh = nums.length/3;
        HashMap<Integer, Integer> count = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : nums) {
            if (count.containsKey(i)) {
                int ct = count.get(i);
                count.put(i, ct+1);
            } else {
                count.put(i, 1);
            }
        }


        count.forEach( (k,v) -> {
            if (v > tresh)
                result.add(k);
        });

        return result;
    }
}
