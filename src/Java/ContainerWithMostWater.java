// 11. Container With Most Water

import org.junit.Test;

public class ContainerWithMostWater {

    // brute force
    public int maxAreaBF(int[] height) {

        int maxAreaGoingRight = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i+1; j < height.length; j++) {
                if (Math.min(height[i], height[j]) * (j-i) > maxAreaGoingRight)
                    maxAreaGoingRight = Math.min(height[i], height[j]) * (j-i);
            }
        }

        return maxAreaGoingRight;
    }

    public int maxArea(int [] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));

            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return maxArea;
    }


    @Test
    public void test() {
        System.out.println(maxArea(new int [] {1,8,6,2,5,4,8,3,7}));
    }

}
