import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {

    private int executeStar(String s, char matchLetter, int index) {
        while (index < s.length() && s.charAt(index) == matchLetter) {
            index++;
        }

        return index;
    }

    private int executeDotStar(String s, char stoppingPoint, int index) {

        if (stoppingPoint == '^')
            return s.length();

        while (index < s.length() && s.charAt(index) != stoppingPoint) {
            index++;
        }

        return index;
    }

    private int executeDot(String s, String patternAfterDot, int index) {
        char matchLetter = patternAfterDot.charAt(0);

        while (index < s.length() && s.charAt(index) != matchLetter) {
            index++;
        }

        if (s.charAt(index) == matchLetter)
            index++;

        return index;
    }

    /*
    *
    * public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    * */


    public boolean isMatch(String s, String p) {

        List<String> brokenPattern = new ArrayList<>();

        for (int i = p.length() - 1; i >= 0 ; i--) {

            if (p.charAt(i) == '*') {
                brokenPattern.add(0, p.charAt(i-1) + "" + p.charAt(i));
                i--;
            } else {
                brokenPattern.add(0, p.charAt(i) + "");
            }
        }

        for (int i = 0; i < brokenPattern.size(); i++) {
            String currPattern = brokenPattern.get(i);
            if (i > 0 && currPattern.contains("*") && currPattern.charAt(0) == brokenPattern.get(i-1).charAt(0)) {
                brokenPattern.remove(i-1);
            } else if (i < brokenPattern.size() - 1 && currPattern.contains("*") && currPattern.charAt(0) == brokenPattern.get(i+1).charAt(0)) {
                brokenPattern.remove(i+1);
            }
        }

        int i = 0;
        int j = 0;
        while (brokenPattern.size() > 0) {

            String currPattern = brokenPattern.get(j);

            while (i < s.length()) {

                if (currPattern.contains("*") && !currPattern.contains(".")) {
                   i =  executeStar(s, currPattern.charAt(0), i);
                   break;
                } else if (currPattern.contains("*") && currPattern.contains(".")) {
                    char stoppingPoint = '^';
                    if (brokenPattern.size() > 1) {
                        stoppingPoint = brokenPattern.get(j+1).charAt(0);
                    }
                    i = executeDotStar(s, stoppingPoint, i);
                    break;
                }
                else if (currPattern.equals(".")) {

                    if (brokenPattern.size() > 1) {
                       i =  executeDot(s, brokenPattern.get(j+1), i);
                       break;
                    } else {
                        i++;
                        break;
                    }
                } else if (currPattern.charAt(0) == s.charAt(i)){
                    i++;
                    break;
                } else {
                    return false;
                }
            }

            brokenPattern.remove(currPattern);
            if (i == s.length() && brokenPattern.size() != 0) {
                break;
            }

        }

        return i == s.length() && brokenPattern.size() == 0;
    }

}
