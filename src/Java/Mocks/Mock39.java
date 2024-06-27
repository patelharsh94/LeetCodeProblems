package Mocks;

import org.junit.Test;

import java.util.Stack;

public class Mock39 {

    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int currMultiplier = 10;
        int prevMultiplier = 1;
        Stack<Integer> palindromeStack = new Stack<>();

        int totalLen = 0;
        int lenX = x;
        while (lenX > 0) {
            totalLen ++;
            lenX /= currMultiplier;
        }

        int i = 0;

        while (i < totalLen/2) {
            palindromeStack.push((x%currMultiplier)/prevMultiplier);
            prevMultiplier = currMultiplier;
            currMultiplier *= 10;
            i++;
        }

        int firstHalf = x;
        i = 0;

        while (i < totalLen/2) {
            firstHalf /= 10;
            i++;
        }

        int secondHalf = 0;

        while (!palindromeStack.empty()) {
            int num = palindromeStack.pop();
        }

        return true;
    }

    @Test
    public void test() {

        isPalindrome(1410110141);
    }

}
