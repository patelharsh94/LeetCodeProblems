package Mocks;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Mock2 {

    /*
     * Students are asked to stand in non-decreasing order of heights for an annual photo.
     * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
     * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
     */

    public int heightChecker(int[] heights) {
        int[] oldArr = Arrays.copyOf(heights, heights.length);

        Arrays.sort(heights);

        int diff = 0;

        for (int i = 0; i < heights.length; i++) {

            if (oldArr[i] != heights[i])
                diff++;
        }

        return diff;
    }

    @Test
    public void testHeightChecker() {
        heightChecker(new int[]{1, 1, 4, 2, 2, 1});
    }


    /*
     * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
     * the key might get long pressed, and the character will be typed 1 or more times.
     * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
     * with some characters (possibly none) being long pressed.
     * */

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (j < typed.length()) {

            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) j++;
            else return false;
        }
        return i == name.length();
    }

    @Test
    public void testIsLongPressed() {
        //System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
        System.out.println(isLongPressedName("alex", "aaleex"));
    }

}
