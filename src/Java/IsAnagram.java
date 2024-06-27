import org.junit.Test;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {


        if (s.length() == t.length()) {

            StringBuilder sb = new StringBuilder(t);

            for (int i = 0; i < s.length(); i++) {
                if (sb.indexOf(s.charAt(i) + "") == -1) {
                    return false;
                } else {
                    sb.deleteCharAt(sb.indexOf(s.charAt(i) + ""));
                }
            }
            return true;
        }

        return false;

    }

    @Test
    public void test() {
        System.out.println(isAnagram("rat", "car"));
    }
}


