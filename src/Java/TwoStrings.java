import java.util.HashSet;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        HashSet<Character> str = new HashSet<>();

        for (char c: s1.toCharArray()) {
            str.add(c);
        }

        for (char c: s2.toCharArray()) {
            if (str.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }
}
