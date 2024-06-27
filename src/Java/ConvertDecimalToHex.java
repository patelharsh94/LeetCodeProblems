import org.junit.Test;

public class ConvertDecimalToHex {

    // https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    public String toHex(int num) {

        String bin = convertToBinary(num);
        System.out.println(bin);

        return bin;
    }

    public String converToHex(String binStr) {

        StringBuilder sb = new StringBuilder(binStr);
        StringBuilder currNum = new StringBuilder();
        int j = 0;

//        for (int i = sb.length()-1; i >= 0; i--) {
//
//        }

        return null;

    }

    public String convertToBinary(int num) {

        int currNum = Math.abs(num);
        boolean isNeg = num < 0;
        StringBuilder sb = new StringBuilder();

        while (currNum > 0) {
            int rem = currNum % 2;
            sb.append(rem);
            currNum /= 2;
        }

        if (isNeg) {
            for (int i =  0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
            }
        }

        return sb.reverse().toString();
    }

    @Test
    public void test() {
        toHex(167);
    }

}
