public class GCD {

    public boolean isGCD(int [] arr, int gcd) {

        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] % gcd != 0)
                return false;
        }

        return true;
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int currGCD = 1;
        int workingGcd = 1;

        for (int i = 0; i < num; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        while (currGCD < max) {
            if (isGCD(arr, currGCD))
                workingGcd = currGCD;

            currGCD++;
        }

        return  workingGcd;
    }
}
