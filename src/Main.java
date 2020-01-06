import BloombergPractice.RandomizedSet;
import BloombergPractice.RemoveToMakeValidParenthesis;
import BloombergPractice.Subsets;
import BloombergPractice.TwoCitySchedulingCost;
import DataStructuresAndAlgoImplementations.MergeSort;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int num = 121;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}


