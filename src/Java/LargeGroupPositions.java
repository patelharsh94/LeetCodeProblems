import org.junit.Test;

import java.util.*;

public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();

        int l = 0;
        int r = 1;

        while (r < S.length()) {

            while (r < S.length() && S.charAt(r) == S.charAt(l)) {
                r++;
            }

            if (r - l >= 3) {
                List<Integer> group = new ArrayList<>();
                group.add(l);
                group.add(r-1);
                result.add(group);
            }

            l = r;
        }

        return result;
    }


    @Test
    public void test() {
        String str = "bababbabaa";
        System.out.println(largeGroupPositions(str));

        String str1 = "abbxxxxzzy";
        System.out.println(largeGroupPositions(str1));

        String str2 = "abc";
        System.out.println(largeGroupPositions(str2));

        String str3 = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(str3));

        String str4 = "aaa";
        System.out.println(largeGroupPositions(str4));
    }

}
