import org.junit.Test;

import java.util.HashMap;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c: s.toCharArray()) {

            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                int count = charCount.get(c);
                charCount.put(c, count+1);
            }
        }
        int minIndex = Integer.MAX_VALUE;

        for(char c : charCount.keySet()) {
            if (charCount.get(c) == 1 && s.indexOf(c) < minIndex) {
                minIndex = s.indexOf(c);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    @Test
    public void test() {
        System.out.println(firstUniqChar("cc"));
    }

}
