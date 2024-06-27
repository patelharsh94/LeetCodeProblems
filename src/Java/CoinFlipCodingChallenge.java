
import org.junit.Test;

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CoinFlipCodingChallenge {

    public static String ArrayChallenge(String[] strArr) {

        String wordCombo = strArr[0];
        String[] wordDict = strArr[1].split(",");

        Arrays.sort(wordDict, new java.util.Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < wordDict.length; i++) {

            if (wordCombo.contains(wordDict[i])) {
                if (wordCombo.indexOf(wordDict[i]) == 0) {
                    String firstWord = wordDict[i];
                    wordCombo = wordCombo.replace(wordDict[i], "");

                    if (strArr[1].contains(wordCombo)) {
                        return firstWord + "," + wordCombo;
                    }
                }
            }
        }

        return "not possible";

    }

    @Test
    public void test1() {
        String[] testArr = new String[]{"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        ArrayChallenge(testArr);
    }


    /*
     * Have the function StringChallenge(strArr) read the array of strings stored in strArr, which will contain two
     * elements, the first will be a positive decimal number and the second element will be a binary number.
     * Your goal is to determine how many digits in the binary number need to be changed to represent the decimal
     * number correctly (either 0 change to 1 or vice versa). For example: if strArr is ["56", "011000"]
     * then your program should return 1 because only 1 digit needs to change in the binary number
     * (the first zero needs to become a 1) to correctly represent 56 in binary.
     * */

    public static String StringChallenge(String[] strArr) {

        String binaryNum = Integer.toBinaryString(Integer.valueOf(strArr[0]));
        int digsToChange = Math.abs(strArr[1].length() - binaryNum.length());

        for (int i = 0; i < binaryNum.length() && i < strArr[1].length(); i++) {
            if (binaryNum.charAt(i) != strArr[1].charAt(i)) {
                digsToChange++;
            }
        }

        return String.valueOf(digsToChange);
    }

    @Test
    public void test2() {

        StringChallenge(new String[]{"44", "111111"});

    }


    /*
     * Have the function SearchingChallenge(str) take str which will be a string and return the longest pattern within
     * the string. A pattern for this challenge will be defined as: if at least 2 or more adjacent characters within
     * the string repeat at least twice. So for example "aabecaa" contains the pattern aa, on the other hand "abbbaac"
     * doesn't contain any pattern. Your program should return yes/no pattern/null. So if str were "aabejiabkfabed" the
     * output should be yes abe. If str were "123224" the output should return no null. The string may either contain all
     * characters (a through z only), integers, or both. But the parameter will always be a string type. The maximum
     * length for the string being passed in will be 20 characters. If a string for example is "aa2bbbaacbbb" the
     * pattern is "bbb" and not "aa". You must always return the longest pattern possible.
     * */
    public static String SearchingChallenge(String str) {

        for (int i = str.length() / 2; i >= 2; i--) {

            for (int j = 0; j + i <= str.length(); j++) {
                String currPattern = str.substring(j, j + i);

                if (str.substring(j + 1).contains(currPattern)) {
                    return "yes " + currPattern;
                }
            }
        }

        return "no null";
    }


    @Test
    public void test3() {
        System.out.println(SearchingChallenge("da2kr32a342"));
    }

    public static void main(String[] args) {
        backend2();
    }

    public static void backend2() {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            StringBuilder streamData = new StringBuilder();
            List <String> ageList = new ArrayList<>();
            String regEx = "age=[0-9]*";
            Pattern pattern = Pattern.compile(regEx);
            int i;
            int ageCount = 0;
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                while ((i = inputStream.read()) != -1) {
                    streamData.append((char) i);
                }
                String [] streamDataArr = streamData.toString().split(",");

                for (String data : streamDataArr) {
                    data = data.replaceAll("}", "");
                    data = data.replaceAll("\"", "");
                    if (data.contains("age") && Integer.valueOf(data.substring(data.indexOf("=")+1)) >= 50) {
                        ageCount++;
                    }
                }

                System.out.println(ageCount);

            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }

    }

    public void backend1() {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            int i;
            StringBuilder streamData = new StringBuilder();

            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();

                while ((i = inputStream.read()) != -1) {
                    streamData.append((char) i);
                }

                String hobbyArrStr = streamData.substring(streamData.indexOf("["));
                hobbyArrStr = hobbyArrStr.replaceAll("\"", "");
                hobbyArrStr = hobbyArrStr.replaceAll("\\[", "");
                hobbyArrStr = hobbyArrStr.replaceAll("]", "");
                hobbyArrStr = hobbyArrStr.replaceAll("}", "");
                hobbyArrStr = hobbyArrStr.replaceAll(",", ", ");
                System.out.println(hobbyArrStr);
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }

}
