public class NumberOfOccurances {

    int getNumberOfOccurances(int [] arr, int target) {

        int leftIndex = getSubStringIndex(arr, 0, arr.length - 1, true, target);
        int rightIndex = getSubStringIndex(arr, leftIndex+1, arr.length - 1, false, target);

        return (rightIndex - leftIndex) + 1;
    }

    int getSubStringIndex(int [] arr, int left, int right, boolean isLeft, int target) {

        while (left < right) {

            int mid = (right - left)/2;

            if ((isLeft && arr[mid] == target && arr[mid - 1] != target) ||
                    (!isLeft && arr[mid] == target && arr[mid + 1] != target))
            {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

}
