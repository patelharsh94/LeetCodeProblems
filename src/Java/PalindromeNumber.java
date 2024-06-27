// # 9. Palindrome Number

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        String xStr =  String.valueOf(x);

        int i = 0;
        int j = xStr.length() - 1;

        while (i < j) {

            if (xStr.charAt(i) != xStr.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}
