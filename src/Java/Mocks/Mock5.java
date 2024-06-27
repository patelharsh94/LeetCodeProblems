package Mocks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Mock5 {

    public String removeOuterParentheses(String S) {

        Stack<Character> parenStack = new Stack<>();
        StringBuilder sb = new StringBuilder(S);

        int start = 0;

        int i = 0;
        for (Character s : S.toCharArray()) {

            if (!parenStack.empty()) {
                if (s == ')' && parenStack.size() == 1 ) {
                    sb.replace(start, start+1, "");
                    sb.replace(i-1, i, "");
                    start = i;
                    i-=2;
                }
            }

            if (s == '(') {
                parenStack.push(s);
            } else {
                parenStack.pop();
            }
            i++;
        }

        return sb.toString();
    }

    @Test
    public void testRemoveOuterParens() {

        String s = "(()())(())";

        assertEquals("()()()", removeOuterParentheses(s));

    }

    private boolean gamePlay (int N, ArrayList<Integer> divisors, boolean isAlice) {

        if (isAlice && divisors.isEmpty()) {
            return false;
        } else if (!isAlice && divisors.isEmpty()) {
            return true;
        } else {
            for (Integer n: divisors) {
                return gamePlay(N-n, getDivisors(N-n), !isAlice);
            }
        }
        return false;
    }

    public boolean divisorGame(int N) {

        int num = N;
        ArrayList<Integer> parentDivisors = getDivisors(num);

        for (int n : parentDivisors) {
            if (gamePlay(N - n, parentDivisors, true))
                return true;
        }

        return false;
    }

    private ArrayList<Integer> getDivisors(int N) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }

        return  divisors;
    }

    @Test
    public void testDivisorGame() {

        assertTrue(divisorGame(2));
        assertFalse(divisorGame(3));
    }
}
