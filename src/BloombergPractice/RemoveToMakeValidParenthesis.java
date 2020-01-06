package BloombergPractice;

import java.util.Stack;

public class RemoveToMakeValidParenthesis {

    public String minRemoveToMakeValid(String s) {

        Stack<Character> parenthesisStack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        int i = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                parenthesisStack.add(c);
            }

            if (c == ')' && !parenthesisStack.empty()) {
                parenthesisStack.pop();
            } else if (c == ')' && parenthesisStack.empty()) {
                sb.replace(i, i+1, "");
            }
            i++;
        }


        if (!parenthesisStack.empty()) {
            i = 0;
            s = sb.toString();
            for (char c : s.toCharArray()) {

                if (!parenthesisStack.empty() && c == '(') {
                    parenthesisStack.pop();
                    sb.replace(i, i+1, "");
                    i--;
                }
                i++;
            }
        }


        return sb.toString();
    }

}
