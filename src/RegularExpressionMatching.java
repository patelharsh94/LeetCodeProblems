import java.util.ArrayList;
import java.util.List;

class Pattern {

    char currVal;
    char preVal;
    char nextVal;

    boolean isStar;
    boolean isDot;
    int index;

    public Pattern(char currVal, char preVal, char nextVal, boolean isStar, boolean isDot, int index) {
        this.currVal = currVal;
        this.preVal = preVal;
        this.nextVal = nextVal;
        this.isStar = isStar;
        this.isDot = isDot;
        this.index = index;
    }
}

class CharVal {

    char currVal;
    int index;

    public CharVal(char currVal, int index) {
        this.currVal = currVal;
        this.index = index;
    }
}

public class RegularExpressionMatching {

    public int executePattern (CharVal s, Pattern pattern) {

        int currIndex = pattern.index;

        if (pattern.isStar)
            return executeStar(s, pattern);
        else if (pattern.isDot)
            return executeDot(s, pattern);
        else
            return 1;
    }

    public int executeStar(CharVal s, Pattern pattern) {

        int index = pattern.index;

        if (index > 0) {
            char prevChar = pattern.preVal;
            char nextChar = pattern.nextVal;


        } else {
            return 0;
        }
        return 0;
    }
    public int executeDot(CharVal s, Pattern pattern) { return 0; }

    public boolean isMatch(String s, String p) {

        List<Pattern> patternList = new ArrayList<>();
        List<CharVal> expressionsList = new ArrayList<>();


        for (int i = p.length() - 1; i > 1 ; i--) {

            Pattern block;
            if (p.charAt(i) == '*') {
                block = new Pattern(p.charAt(i), p.charAt(i-1),  p.charAt(i-2), true, false, i);
            } else if (p.charAt(i) == '.') {
                block = new Pattern(p.charAt(i), p.charAt(i-1),  p.charAt(i-2), false, true, i);
            } else {
                block = new Pattern(p.charAt(i), p.charAt(i-1),  p.charAt(i-2), false, false, i);
            }
            patternList.add(0, block);
        }

        patternList.add(0, new Pattern(p.charAt(0), ' ', p.charAt(1), p.charAt(0) == '*', p.charAt(0) == '.', 0));

        for (int i = 0; i < s.length(); i++) {
            expressionsList.add(new CharVal(s.charAt(i), i));
        }



        return false;
    }

}

/*
* old:
*
* import java.util.ArrayList;
import java.util.List;

class Scratch {

}

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
* */
