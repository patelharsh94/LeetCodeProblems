import org.junit.Test;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        int a = 0;
        int b = 0;

        if (s != null && p != null && s.length() > 0 && p.length() > 0) {

            while (a < s.length() && b < p.length()) {
                if (p.charAt(b) == '?' || s.charAt(a) == p.charAt(b)) {
                    a++;
                    b++;
                } else if (b < p.length() - 1 && p.charAt(b) == '*') {

                    while (s.charAt(a) != p.charAt(b + 1)) {
                        a++;
                    }

                    b += 2;
                } else if (b == p.length() - 1 && p.charAt(b) == '*') {
                    return true;
                } else if (s.charAt(a) != p.charAt(b)) {
                    return false;
                }
            }

            if (a < s.length() || b < p.length())
                return false;
            else
                return true;
        }

        return false;
    }


    @Test
    public void test() {
        System.out.println(isMatch("adceb",
                "*a*b"));
    }

}
