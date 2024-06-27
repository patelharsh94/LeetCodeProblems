package MicrosoftCodingChallenge;

public class MicrosoftQ1 {

    public void solution(int N) {

        /* Using StringBuilder because String is immutable, and string concatenation
           will be an expensive operation, compared to StringBuilder's append operation.
           Since java will make copies of the string, and allocate new memory every time we
           use the "+" operator.
        */
        StringBuilder divisibilityText = new StringBuilder();

        // So we can print all values inclusive from 1 to 24.
        for (int i = 1; i < N+1; i++) {

            // if the number is divisible by 2, print Codility
            if (i % 2 == 0) {
                divisibilityText.append("Codility");
            }

            // if the number is divisible by 3, print Test
            if (i % 3 == 0) {
                divisibilityText.append("Test");
            }

            // if the number is divisible by 5, print Coders
            if (i % 5 == 0) {
                divisibilityText.append("Coders");
            }

            // if any of the above conditions were met.
            if (divisibilityText.length() > 0) {

                // print the final string on a new line.
                System.out.println(divisibilityText.toString());

                // initializing a new StringBuilder only when needed.
                divisibilityText = new StringBuilder();
            } else {
                // if conditions were not met, print the number.
                System.out.println(i);
            }
        }

    }

}
