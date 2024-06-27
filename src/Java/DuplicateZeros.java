public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {

        int currArrayPtr = 0;
        int j = 0;
        int diffNum;

        while (j < arr.length - currArrayPtr) {
            if (arr[j] == 0) {
                currArrayPtr++;
            }
            j++;
        }

        diffNum = arr.length - j;
        int last = arr.length-diffNum-1;

        for (int i = last;  i >= 0; i--) {

            if (arr[i] == 0) {
                arr[i+diffNum] = 0;
                diffNum--;
                arr[i+diffNum] = 0;
            } else {
                arr[i+diffNum] = arr[i];
            }

            if (diffNum <= 0)
                break;
        }

        return;
    }
}
