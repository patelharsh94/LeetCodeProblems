import org.junit.Test;

import java.util.*;

// 17. Letter Combinations of a Phone Number

public class LetterCombination {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() < 1)
            return result;

        String [] combos = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        getCombos(result, 0, new StringBuilder(), digits, combos);

        return result;
    }


    public void getCombos(List<String> result, int index, StringBuilder current,  String digits, String [] combos) {

        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        String currCombo = combos[digits.charAt(index) - '0'];

        for (int i = 0; i < currCombo.length(); i++) {
            current.append(currCombo.charAt(i));
            getCombos(result, index+1, current, digits, combos);
            current.deleteCharAt(current.length()-1);
        }

    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }

}
