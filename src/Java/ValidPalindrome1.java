
// 125. Valid Palindrome

import org.junit.Test;

// 125. Valid Palindrome
public class ValidPalindrome1 {

    public boolean isPalindrome(String s) {


        if (s == null) {
            return false;
        }

        s = s.toLowerCase();

        if (s.length() == 1)
            return true;

        int start = 0; int end = s.length() - 1;

        while (start < end) {

            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            while (!isAlphaNum(startChar) && start < end) {
                start++;
                startChar = s.charAt(start);
            }

            while (!isAlphaNum(endChar) && start < end) {
                end--;
                endChar = s.charAt(end);
            }

            if (startChar != endChar) {
                return false;
            }

            else {
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    @Test
    public void test() {
        System.out.println(isPalindrome("0P"));
    }


}
