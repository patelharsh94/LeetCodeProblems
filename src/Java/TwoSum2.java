// 167. Two Sum II - Input array is sorted


public class TwoSum2 {

    public int binSearch(int [] nums, int target, int firstIndex) {

        int min = 0;
        int max = nums.length;
        int mid = (max + min - 1) / 2;

        while (min < max) {

            if (nums[mid] == target) {

                if (mid == firstIndex) {
                    if (nums[mid + 1] == target)
                        return mid + 2;
                    if (nums[mid - 1] == target)
                        return mid;
                }
                return mid + 1;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

            mid = (max + min - 1) / 2;
        }

        return Integer.MIN_VALUE;
    }

    public int[] twoSum(int[] numbers, int target) {

        int newTarget = 0;
        int [] solution = new int [2];

        for (int i = 0; i < numbers.length; i++) {
            newTarget = target - numbers[i];
            if (newTarget >= 0) {
                int targetIndex = binSearch(numbers, newTarget, i);

                if (targetIndex != Integer.MIN_VALUE) {
                    solution [0] = i + 1 < targetIndex ? i + 1 : targetIndex;
                    solution [1] = solution [0] == i + 1 ? targetIndex : i + 1;

                    return solution;
                }
            }
        }

        return null;
    }


//    public int [] twoSum (int [] numbers, int target) {
//
//    }
}
