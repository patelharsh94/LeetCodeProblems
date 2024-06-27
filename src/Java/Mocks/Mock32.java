package Mocks;

import java.util.*;

public class Mock32 {

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public String removeKdigits(String num, int k) {


        Stack<Integer> lowestNum = new Stack<>();
        lowestNum.add(num.charAt(0) - '0');

        if (num.length() == 1 && k == 1)
            return "0";

        for (int i = 1; i < num.length(); i++) {
            int curNum = num.charAt(i) - '0';

            while (lowestNum.size() > 0 && curNum < lowestNum.peek() && k > 0) {
                lowestNum.pop();
                k--;
            }
            lowestNum.push(curNum);
        }

        while (k > 0 && lowestNum.size() != 0) {
            lowestNum.pop();
        }

        if (lowestNum.size() == 0)
            return "0";


        StringBuilder output = new StringBuilder();
        lowestNum.forEach(val -> output.append(val));
        return output.toString();
    }

}
