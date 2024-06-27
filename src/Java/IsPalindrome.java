public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) < 'a' || sb.charAt(i) > 'z') {
                sb.replace(i, i+1, "");
                i--;
            }
        }
        int i = 0, j = s.length()-1;

        if (sb.length() < 2)
            return true;

        while(i < j) {

            if (sb.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }

        return true;
    }
}
