import org.junit.Test;

// 680. Valid Palindrome II
public class ValidPalindrome {

    public boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        int diff = 0;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }
            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindrome(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(validPalindrome("deeee"));
    }
}
