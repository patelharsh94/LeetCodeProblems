public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {

        StringBuilder reverseString = new StringBuilder();
        StringBuilder freeStr = new StringBuilder();



        for (int i = 0; i < S.length(); i++) {

            if (Character.isAlphabetic(S.charAt(i)))
                freeStr.append(S.charAt(i));
        }

        String freeString = freeStr.reverse().toString();
        int j = 0;

        for (int i = 0; i < S.length(); i++) {

            char currChar = S.charAt(i);

            if (Character.isAlphabetic(currChar)) {
                char reverseChar = freeString.charAt(j);
                reverseString.append(reverseChar);
                j++;
            } else {
                reverseString.append(currChar);
            }

        }

        return reverseString.toString();
    }
}
