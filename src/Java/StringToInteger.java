import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    // 8. String to Integer (atoi)
    public int myAtoi(String str) {

        if (str != null && str.trim().length() > 0) {
            str = str.trim();
            boolean isNegative = false;
            StringBuilder integerStr = new StringBuilder();
            List<Integer> number = new ArrayList<>();
            int i = 0;

            if (str.charAt(0) == '-') {
                isNegative = true;
                i++;
            }

            if (str.charAt(0) == '+') {
                i++;
            }
            boolean firstDig = false;

            while (i < str.length()) {

                if (str.charAt(i) == '0' && !firstDig) {
                    i++;
                    continue;
                }

                if (Character.isDigit(str.charAt(i))) {
                    number.add(str.charAt(i) - '0');
                    firstDig = true;
                }
                else
                    break;
                i++;
            }

            int finalResult = 0;

            if (number.size() == 0)
                return 0;

            i = 0;

            if (number.size() >= 10 && number.get(0) > 2) {
                finalResult = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                while(i < number.size()) {
                    int futureVal = (number.get(i)) * (int)(Math.pow(10, number.size()-1-i));

                    if (finalResult+futureVal > 0) {
                        finalResult = finalResult+futureVal;
                    } else {
                        if (isNegative)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                    i++;
                }
            }

            return isNegative ? -1*finalResult : finalResult;
        }

        return 0;
    }
}
