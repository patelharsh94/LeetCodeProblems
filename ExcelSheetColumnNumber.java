public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int totalCount = 0;
        double multiplier = s.length()-1;
        for (char a : s.toCharArray()) {
            totalCount += (a-64) * Math.pow(26.0, multiplier);
            multiplier--;
        }

        return totalCount;
    }

}
