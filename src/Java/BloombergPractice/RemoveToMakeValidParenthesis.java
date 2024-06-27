package BloombergPractice;

import java.util.Stack;

// 1249. Minimum Remove to Make Valid Parentheses

public class RemoveToMakeValidParenthesis {

    class ParenthesisLocation {
        char c;
        int index;

        ParenthesisLocation(char c, int i) {
            this.c = c;
            this.index = i;
        }

    }

    public String minRemoveToMakeValid(String s) {

        Stack<ParenthesisLocation> parenthesisStack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {

            char c = sb.charAt(i);
            if (c == '(') {
                parenthesisStack.add(new ParenthesisLocation(c, i));
            }

            if (c == ')' && !parenthesisStack.empty()) {
                parenthesisStack.pop();
            } else if (c == ')' && parenthesisStack.empty()) {
                sb.replace(i, i+1, "");
                i--;
            }
        }

        while (!parenthesisStack.empty()) {
            sb.setCharAt(parenthesisStack.pop().index, '*');
        }

        String finalStr = sb.toString();
        finalStr = finalStr.replaceAll("\\*", "");

        return finalStr;
    }

}
