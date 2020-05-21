package Mocks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

class KthLargest {

    ArrayList<Integer> arr;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.arr = new ArrayList<>();

        Arrays.sort(nums);

        for (int val: nums)
            this.arr.add(val);
    }

    public int add(int val) {

        if (this.arr.size() == 0) {
            this.arr.add(val);
        }

        for (int i = 0; i < arr.size(); i++) {
            int currNum = arr.get(i);

            if (i > 0 && val <= currNum && val > arr.get(i-1))  {
                arr.add(i, val);
                break;
            } else if ( i == 0 && val <= currNum) {
                arr.add(0, val);
                break;
            } else if (i == arr.size()-1) {
                arr.add(val);
                break;
            }
        }

        return this.arr.get(this.arr.size() - k);
    }
}
public class Mock3 {

    @Test
    public void testingKthLargest() {
//        KthLargest kthLargest = new KthLargest(3, new int [] {4,5,8,2});
//
//        System.out.println(kthLargest.add(-2));
//        System.out.println(kthLargest.add(5));
//        System.out.println(kthLargest.add(10));
//        System.out.println(kthLargest.add(9));
//        System.out.println(kthLargest.add(4));

//        KthLargest kthLargest = new KthLargest(1, new int [] {});
//
//        System.out.println(kthLargest.add(-3));
//        System.out.println(kthLargest.add(-2));
//        System.out.println(kthLargest.add(-4));
//        System.out.println(kthLargest.add(0));
//        System.out.println(kthLargest.add(4));

        KthLargest kthLargest = new KthLargest(3, new int [] {5, -1});

        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));

    }

    /*
    *
    * We have two special characters. The first character can be represented by one bit 0. The second character can be
    * represented by two bits (10 or 11).
    * Now given a string represented by several bits. Return whether the last character must be a one-bit
    * character or not. The given string will always end with a zero.
    * */

    public boolean isOneBitCharacter(int[] bits) {

        boolean isOneBit = false;
        if (bits.length == 1)
            return true;
        // if odd return true
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 0) {
                i++;
                isOneBit = true;
                continue;
            }
            if (bits[i] == 1) {
                i+=2;
                isOneBit = false;
            }
        }

        return isOneBit;
    }

    @Test
    public void testingIsOneButCharacter() {
        assertTrue(isOneBitCharacter(new int[]{0}));
        assertFalse(isOneBitCharacter(new int[]{1,0}));
        assertFalse(isOneBitCharacter(new int[]{1,1}));
        assertFalse(isOneBitCharacter(new int[]{0,1,0}));
        assertTrue(isOneBitCharacter(new int[]{1,0,1,1,0,0}));
    }
}
