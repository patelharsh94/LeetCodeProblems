import org.junit.Test;

import java.util.HashSet;

public class LongestUniqueSubstring {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        if (s.length() == 1)
            return 1;

        for (int i = 0; i < s.length(); i++) {
            int [] visited = new int [256];
            for (int j = i; j < s.length(); j++) {

                if (visited[s.charAt(j)] == 0) {
                    visited[s.charAt(j)] = s.charAt(j);
                } else {
                    max = Math.max(j-i, max);
                    break;
                }

                if (j == s.length() - 1) {
                    max = Math.max(j-i+1, max);
                    break;
                }
            }
        }

        return max;
    }


    @Test
    public void test() {
        lengthOfLongestSubstring("ab");
    }

}
