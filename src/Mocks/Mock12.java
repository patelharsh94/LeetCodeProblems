package Mocks;

public class Mock12 {

    public int findPeakElement(int[] nums) {

        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        return -1;
    }


    public boolean repeatedSubstringPattern(String s) {

        if (s.length() < 2) {
            return false;
        } else {
            int i = s.length() / 2;

            while (i > 0) {

                if (s.substring(0, i).equals(s.substring(i + 1, s.length() - 1)))
                    return true;

                i /= 2;
            }
        }

        return false;
    }


}
