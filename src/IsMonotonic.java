// 896. Monotonic Array

public class IsMonotonic {
    public boolean isMonotonic(int[] A) {

        if (A.length == 1)
            return true;

        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < A.length-1; i++) {

            if (A[i] >= A[i+1]) {
                isDecreasing = true;
            } else {
                isDecreasing = false;
                break;
            }

        }

        for (int i = 0; i < A.length -1; i++) {
            if (A[i] <= A[i+1]) {
                isIncreasing = true;
            } else {
                isIncreasing = false;
                break;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
