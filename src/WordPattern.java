import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;

// 290. Word Pattern
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        if (pattern != null && str != null && pattern.length() == str.trim().split(" ").length) {

            String [] words = str.split(" ");

            HashMap<Character, String> patternWordMap = new HashMap<>();
            patternWordMap.put(pattern.charAt(0), words[0]);

            for (int a = 1; a < pattern.length(); a++) {

                if (pattern.charAt(a) != pattern.charAt(a-1) && words[a].equals(words[a-1]))
                    return false;

                if (pattern.charAt(a) == pattern.charAt(a-1) && !words[a].equals(words[a-1]))
                    return false;

                if (patternWordMap.get(pattern.charAt(a)) == null) {
                    patternWordMap.put(pattern.charAt(a), words[a]);
                } else {
                    if (!words[a].equals(patternWordMap.get(pattern.charAt(a))))
                        return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    @Test
    public void test() {
        String pattern = "aba";
        String word = "cat cat cat dog";

        assertFalse(wordPattern(pattern, word));
    }

}
