public class NumberOfOccurances {

    int getNumberOfOccurances(int [] arr, int target) {

        int leftIndex = getSubStringIndex(arr, 0, arr.length - 1, true, target);
        int rightIndex = getSubStringIndex(arr, 0, arr.length - 1, false, target);

        if (rightIndex - leftIndex > 0)
            return (rightIndex - leftIndex) + 1;
        else if (arr[leftIndex] == target || arr[rightIndex] == target)
            return 1;
        else
            return 0;
    }

    int getSubStringIndex(int [] arr, int left, int right, boolean isLeft, int target) {

        while (left <= right) {

            double midDouble = Math.floor(((double) right + left) / 2);
            int mid = (int) midDouble;

            if ((mid == 0 || mid == arr.length - 1 ) && arr[mid] == target)
            {
                return mid;
            } else if ((isLeft && arr[mid] == target && arr[mid - 1] != target) ||
                    (!isLeft && arr[mid] == target && arr[mid + 1] != target))
            {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target){
                right = mid - 1;
            } else if (isLeft) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return 0;
    }

}
