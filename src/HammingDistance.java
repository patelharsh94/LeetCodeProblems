import org.junit.Test;

public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int hammingDist = 0;
        int leftOverX = x;
        int leftOverY = y;

        while (leftOverX != 0 || leftOverY != 0) {

            if (leftOverX % 2 != leftOverY % 2) {
                hammingDist++;
            }

            leftOverX /= 2;
            leftOverY /= 2;
        }

        return hammingDist;
    }

    // Easy solution
    // https://leetcode.com/problems/hamming-distance/discuss/94698/Java-1-Line-Solution-%3AD
    // ^ = XOR --> 0 0 = 0, 1 0 = 1, 0 1 = 1, 1 1 = 0

    public int hammingDistanceEasySol(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
}
