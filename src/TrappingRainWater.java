public class TrappingRainWater {


    public int [] findMinArray (int [] height) {


        int maxRight = 0;
        int maxLeft = 0;
        int [] rightMax = new int [height.length];
        int [] leftMax = new int [height.length];
        int [] minArray = new int[height.length];

        for (int i = 0; i < height.length; i++) {

            if (maxLeft < height[i]) {
                maxLeft = height[i];
            }

            leftMax[i] = maxLeft;
        }

        for(int i = height.length - 1; i >= 0; i--) {

            if (maxRight < height[i]) {
                maxRight = height[i];
            }

            rightMax[i] = maxRight;
        }


        for (int a = 0; a < height.length; a++) {
            minArray[a] = Integer.min(rightMax[a], leftMax[a]);
        }

        return minArray;
    }

    public int tapRainWater(int[] height) {

        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;

        int [] minArr = this.findMinArray(height);

        for (int i = 0; i < height.length; i++) {

            int water = minArr[i];

            System.out.println("index: " + i);
            System.out.println("Max Left: " + maxLeft);
            System.out.println("Max Right: " + maxRight);
            System.out.println("Adding: " + (water - height[i]));
            trappedWater += (water - height[i]);
        }

        return trappedWater;
    }

}