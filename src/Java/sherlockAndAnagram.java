import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class sherlockAndAnagram {

    static int sherlockAndAnagrams(String s) {

        int totalAnagram = 0;
        HashSet<String> oldSubStrings = new HashSet<>();
        String currSub = "";
        int strLen = 1;

        while (strLen < s.length()) {
            for (int i = 0; i+strLen <= s.length(); i++) {
                char [] charArr = s.substring(i, i+strLen).toCharArray();
                Arrays.sort(charArr);
                currSub = new String(charArr);

                if (oldSubStrings.contains(currSub)) {
                    totalAnagram++;
                } else {
                    oldSubStrings.add(currSub);
                }
            }
            strLen++;
        }


        return totalAnagram;
    }

    @Test
    public void test() {
        System.out.println(sherlockAndAnagrams("kkkk"));
    }
}
