// 6. ZigZag Conversion
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int skipNumber = numRows - 2;

        if (s.length()  < numRows)
            return s;

        int [] [] zigZagArray = new int [numRows] [(Math.floorDiv(s.length(), numRows)*2)+1];

        int i = 0;
        int col = 0;

        StringBuilder result = new StringBuilder();
        boolean isZig = false;

        while (i < s.length()) {
            for (int j = 0; j < numRows; j++) {
                if (i == s.length())
                    break;
                zigZagArray[j][col] = s.charAt(i);
                i++;
            }
            col++;

            for (int k = numRows-2; k >= 1; k--) {
                if (i == s.length())
                    break;
                zigZagArray[k][col] = s.charAt(i);
                isZig = true;
                i++;
            }

            if (isZig)
                col++;
        }

        for (int l = 0; l < zigZagArray.length; l++) {
            for (int m = 0; m < zigZagArray[l].length; m++) {
                if (zigZagArray[l][m] > 0)
                    result.append((char)zigZagArray[l][m]);
            }
        }

        return result.toString();
    }
}
