
import org.junit.Test;

import java.util.*;

public class AtoI {

    public int myAtoi(String s) {

        boolean isNumberFound = false;
        List<Integer> numbers = new ArrayList<>();
        boolean isNegative = false;
        boolean isPositive = false;
        long finalNum = 0;

        for (char c : s.toCharArray()) {


            if ((c == ' ' || c == '+') && !isNumberFound && !isNegative) {
                isPositive = true;
                continue;
            } else if ((c == ' ' || c == '+') && (isNumberFound || isNegative)) {
                return 0;
            } else if (c == '-' && !isNumberFound && !isPositive) {
                isNegative = true;
            } else if (c == '-' && (!isNumberFound || isPositive)) {
                return 0;
            } else if (c >= 48 && c <= 57) {
                numbers.add(c - 48);
                isNumberFound = true;
            } else {
                break;
            }
        }
        int j = 0;
        for (int i = numbers.size()-1; i >= 0; i--) {
            finalNum += numbers.get(i) * Math.pow(10, j);
            j++;
        }

        if (finalNum > Integer.MAX_VALUE && !isNegative) {
            return Integer.MAX_VALUE;
        } else if (finalNum > Integer.MAX_VALUE && isNegative) {
            return Integer.MIN_VALUE;
        }

        int currInt = (int) finalNum;

        return isNegative ? currInt*-1 : currInt;
    }

    @Test
    public void testAtoI() {
        String num = "+-9128";
        System.out.println(myAtoi(num));
    }

}
