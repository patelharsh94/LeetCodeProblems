import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancedString {

    public int balancedString(String s) {

        int total = 0;

        if (s != null && s.length() > 0) {

            int [] charArr = new int [4];
            int fourth = s.length()/4;
            int extra = 0;
            int missing = 0;

            for (char c : s.toCharArray()) {

                if (c == 'Q')
                    charArr[0]++;

                if (c == 'W')
                    charArr[1]++;

                if (c == 'E')
                    charArr[2]++;

                if (c == 'R')
                    charArr[3]++;

            }

            for (int i = 0; i < 4; i++) {
                int currDiff = fourth - charArr[i];

                if (currDiff < 0) {
                    extra += Math.abs(currDiff);
                }

                if (currDiff > 0) {
                    missing += Math.abs(currDiff);
                }
            }

            if (extra != 0 && missing != 0) {

                if (extra == missing) {
                    total += extra;
                }

                if (extra > missing) {
                    total += (extra - missing);
                }
            }
        }

        return total;
    }

    @Test
    public void test() {
//        assertEquals(balancedString("QWER"), 0);
//        assertEquals(balancedString("QQWE"), 1);
//        assertEquals(balancedString("WQWRQQQW"), 3);
        assertEquals(balancedString("WWEQERQWQWWRWWERQWEQ"), 4);
    }

    // https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/660882/Java-Solution-or-Beats-99.77-Submissions.
    public int balancedStringSOLUTION(String s) {
        if(s.length() % 4 != 0) return 0;
        int balanceFactor = s.length() / 4;
        char[] input = s.toCharArray();
        int[] charMap = new int[26];
        for(int i = 0; i < input.length; i++){
            charMap[input[i] - 'A']++;
        }

        int left = 0, right = 0, minWindowSize = Integer.MAX_VALUE;
        while(right < input.length){
            charMap[input[right] - 'A']--;
            //Q = 16 ; W = 22; E = 4; R = 17
            while(charMap[16] <= balanceFactor && charMap[22] <= balanceFactor && charMap[4] <= balanceFactor && charMap[17] <= balanceFactor && left < input.length){
                int currentWindowSize = right - left + 1;
                minWindowSize = Math.min(minWindowSize, currentWindowSize);
                charMap[input[left++] - 'A']++;
            }
            right++;
        }
        return minWindowSize;
    }
}
