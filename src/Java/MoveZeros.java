import org.junit.Test;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int totalZeros = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                totalZeros++;
            } else {
                nums[i-totalZeros] = nums[i];
            }
        }

        for (int i = nums.length - totalZeros; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test() {
        int [] arr = {0,1,0,3,12};
        moveZeroes(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
