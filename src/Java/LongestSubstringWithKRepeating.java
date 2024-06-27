import java.util.ArrayList;
import java.util.List;

// 395. Longest Substring with At Least K Repeating Characters

public class LongestSubstringWithKRepeating {

    public int [] getAlphaCount (String s) {
        int [] alphaCounts = new int [26];
        Integer currCount = 0;

        for (char c : s.toCharArray()) {
            currCount = alphaCounts[c-97];
            alphaCounts[c-97] =  ++currCount;
        }

        return alphaCounts;
    }

    public int getLongestSubString(List<String> subStrings, int k) {
        int [] alphaCounts;
        int maxLength = 0;
        StringBuilder subString;
        List<String> newSubStrings = new ArrayList<>();

        if (subStrings.size() == 0) {
            return 0;
        } else if (subStrings.size() == 1) {
            if (subStrings.get(0).length() >= k)
                return subStrings.get(0).length();
            else
                return 0;
        } else {
            for (String subStr : subStrings) {
                subString = new StringBuilder();
                if (subStr.length() > maxLength) {
                    alphaCounts = getAlphaCount(subStr);
                    for (char c : subStr.toCharArray()) {
                        if (alphaCounts[c-97] < k) {
                            if (subString.toString().length() > maxLength) {
                                maxLength = subString.toString().length();
                                newSubStrings.add(subString.toString());
                            }
                            subString = new StringBuilder();
                        } else {
                            subString.append(c);
                        }
                    }

                    newSubStrings.add(subString.toString());
                }
            }
        }
        maxLength = 0;
        if (newSubStrings.equals(subStrings)) {
            for (String s: newSubStrings) {
                if (maxLength < s.length())
                    maxLength = s.length();
            }
            return maxLength;
        }

        return getLongestSubString(newSubStrings, k);
    }

    public int longestSubstring(String s, int k) {

        int [] alphaCounts;
        List<String> subStrings = new ArrayList<>();
        StringBuilder subString = new StringBuilder();


        alphaCounts = getAlphaCount(s);

        for (char c : s.toCharArray()) {
            if (alphaCounts[c-97] >= k) {
                subString.append(c);
            } else {
                subStrings.add(subString.toString());
                subString = new StringBuilder();
            }
        }

        if (subString.length() != 0 )
            subStrings.add(subString.toString());
        return getLongestSubString(subStrings, k);
    }

}
