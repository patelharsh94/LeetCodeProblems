import java.util.HashSet;
import java.util.Set;

// 5. Longest Palindromic Substring

public class LongestPalindromicSubstring {

    Set<String> palindromeSet = new HashSet<>();


    private boolean isPalindrome(String s) {
        int i = 0; int j = s.length()-1;

        if (i > j)
            j = i;

        if (s.length() < 2) {
            palindromeSet.add(s);
            return true;
        }

        String midString = s.substring(i+1, j);
        char first = s.charAt(0);
        char last = s.charAt(s.length()-1);

        if (first == last && (midString.length() == 0 || palindromeSet.contains(midString)))
        {
            palindromeSet.add(s);
            return true;
        }

        while (i <= j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        palindromeSet.add(s);

        return true;
    }

    public String longestPalindrome(String s) {

        int currPalindromLength = s.length();
        String currMaxPalindrome = "";
        String currPalindrome;

        if (s.length() == 2 && s.charAt(0) == s.charAt(1))
            return s;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1))
            return s.charAt(0) + "";


        while (currPalindromLength >= 0) {
            for (int k = 0; k < s.length()-currPalindromLength+1; k++) {
                currPalindrome = s.substring(k, k+currPalindromLength);
                if (isPalindrome(currPalindrome)) {
                    return currPalindrome;
                }
            }
            currPalindromLength--;
        }



        return currMaxPalindrome.length() == 0  ? s.charAt(0) + "" : currMaxPalindrome;
    }

}
