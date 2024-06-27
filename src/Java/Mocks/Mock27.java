package Mocks;

import java.util.TreeMap;

public class Mock27 {

    public String licenseKeyFormatting(String S, int K) {

        if (S == null || S.length() == 0)
            return S;

        S = S.replaceAll("-", "");
        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder(S);

        int i = S.length()-K;

        while (i > 0) {
            sb.insert(i, "-");
            i -= K;
        }

        return sb.toString();
    }



}
