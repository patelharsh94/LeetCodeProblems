package MicrosoftCodingChallenge;

import java.util.HashSet;
import java.util.Set;

public class MicrosoftQ2 {

    public String solution(String S) {

        // To store all unique occurrences of upper case values.
        Set<Character> upperCaseSet = new HashSet<>();

        char currChar;
        char upperCaseChar;
        char maxChar = 0;

        // so we can pass through the array once.
        for (int i = 0; i < S.length(); i++) {

            // getting the char at index i
            currChar = S.charAt(i);

            // Saving all upper case values in a set.
            if (currChar >= 'A' && currChar <= 'Z') {
                upperCaseSet.add(currChar);
            }
        }

        // going through another time to see if the smaller case values
        // corresponding to the upper case values in the set occur.
        for (int i = 0; i < S.length(); i++) {
            currChar = S.charAt(i);
            // so we don't have to compute it over and over again.
            upperCaseChar = Character.toUpperCase(currChar);
            // if currChar is a lower case value.
            // and currChar is greater than maxChar , save it as maxChar
            if (currChar >= 'a'
                    && currChar <= 'z'
                    && upperCaseSet.contains(upperCaseChar)
                    && maxChar < upperCaseChar) {
                maxChar = upperCaseChar;
            }
        }

        // Solution is Big O (N) run time, and Big O (a) space, where a is the
        // # of upper case letters in the string.
        return maxChar != 0 ? maxChar + "" : "NO";
    }

}
