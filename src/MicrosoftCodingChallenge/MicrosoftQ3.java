package MicrosoftCodingChallenge;

public class MicrosoftQ3 {

    public int solution(int N) {
        boolean isNegative = N < 0;
        int maxNum = isNegative ? Integer.MIN_VALUE : 0;

        StringBuilder number = new StringBuilder(String.valueOf(Math.abs(N)));


        for (int i = 0; i < number.length(); i++) {

            String currNum = number.insert(i, 5).toString();
            System.out.println(currNum);
            int currNumIntegerValue = Integer.valueOf(currNum);

            if (!isNegative && currNumIntegerValue > maxNum) {
                maxNum = currNumIntegerValue;
            } else if (isNegative && -1*currNumIntegerValue > maxNum) {
                maxNum = -1* currNumIntegerValue;
            }

            number.deleteCharAt(i);
        }

        return maxNum;
    }
}
