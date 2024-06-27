import org.junit.Test;

import java.util.HashMap;

public class FractionToDecimal {

    // 166. Fraction to Recurring Decimal
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder str = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            str.append('-');
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long n = num / den;
        long reminder = num % den;
        str.append(n);
        if (reminder == 0) return str.toString();
        else str.append('.');
        while (!map.containsKey(reminder)) {
            map.put(reminder, str.length());
            n = reminder * 10 / den;
            reminder = reminder * 10 % den;
            if (reminder != 0 || reminder == 0 && !map.containsKey(reminder)) {
                str.append(n);
            }
        }
        if (reminder != 0) {
            str.insert(map.get(reminder), "(");
            str.append(')');
        }
        return str.toString();
    }

    @Test
    public void test() {
        System.out.println(fractionToDecimal(-1, 3));
    }
}
