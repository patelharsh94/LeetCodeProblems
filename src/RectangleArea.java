import org.junit.Test;

public class RectangleArea {

    // 223. Rectangle Area
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaT1 = (C-A) * (D-B);
        int areaT2 = (G-E) * (H-F);

        int overlapLeft = Math.max(A,E);
        int overlapRight = Math.min(C, G);
        int overlapBottom = Math.max(B, F);
        int overlapTop = Math.min(D, H);
        int overlapArea = 0;

        if (overlapRight > overlapLeft && overlapTop > overlapBottom) {
            overlapArea = (overlapRight - overlapLeft) * (overlapTop - overlapBottom);
        }

        return areaT1 + areaT2 - overlapArea;
    }


    @Test
    public void test2() {
        System.out.println(computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
    }

}


// inspired from : https://leetcode.com/problems/rectangle-area/discuss/62138/My-Java-solution-Sum-of-areas-Overlapped-area