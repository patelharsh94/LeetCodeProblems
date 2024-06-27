import org.junit.Test;

import java.util.HashSet;

public class HackerRankWarmup {

    static int sockMerchant(int n, int[] ar) {

        HashSet<Integer> singleSock = new HashSet<>();

        for (int num : ar) {

            if (!singleSock.contains(num)) {
                singleSock.add(num);
            } else {
                singleSock.remove(num);
            }
        }

        return (ar.length - singleSock.size())/2;
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int currLevel = 0;
        int totalValleys = 0;

        for (char move : path.toCharArray()) {

            if (move == 'U') {
                currLevel++;
            } else {
                currLevel--;
            }

            if (currLevel == 0) {
                totalValleys++;
            }

        }

        return totalValleys;
    }


    static long repeatedString(String s, long n) {
        int numOfAs = 0;
        long  totalAs = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                numOfAs++;
        }

        long multiple = n / s.length();
        long leftOver = n % s.length();

        totalAs += (numOfAs * multiple);

        for (int i = 0; i < leftOver; i++) {
            if (s.charAt(i) == 'a')
                totalAs++;
        }

        return totalAs;
    }

    @Test
    public void testRepeatedString() {
        repeatedString("aba", 10);
    }

}
