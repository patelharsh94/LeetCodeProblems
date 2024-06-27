package Mocks;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;

public class Mock31 {

    public int reverse(int x) {
        boolean isNeg = false;

        if (x < 0)
            isNeg = true;

        StringBuilder sb = new StringBuilder();
        sb.append(x);

        if (isNeg) {
            sb.reverse();
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.reverse();
        }


        return isNeg ? -1*Integer.valueOf(sb.toString()) : Integer.valueOf(sb.toString());
    }

    @Test
    public void test() {
        System.out.println(reverse(123));
    }

}
