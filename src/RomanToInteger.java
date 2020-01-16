public class RomanToInteger {

    public int romanToInt(String s) {


        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            char currChar = s.charAt(i);
            char nextChat = i < s.length() - 1 ? s.charAt(i+1) : 'K';

            if ((currChar == 'I' && nextChat == 'V') || (currChar == 'I' && nextChat == 'X') ||
                    (currChar == 'X' && nextChat == 'L') || (currChar == 'X' && nextChat == 'C') ||
                    (currChar == 'C' && nextChat == 'D') || (currChar == 'C' && nextChat == 'M')) {
                i++;
            }

            if (currChar == 'I' && nextChat == 'V')
                total += 4;
            else if (currChar == 'I' && nextChat == 'X')
                total += 9;
            else if (currChar == 'I')
                total++;

            if (currChar == 'V')
                total += 5;

            if (currChar == 'X' && nextChat == 'L')
                total += 40;
            else if (currChar == 'X' && nextChat == 'C')
                total += 90;
            else if (currChar == 'X')
                total += 10;

            if (currChar == 'L')
                total += 50;

            if (currChar == 'C' && nextChat == 'D')
                total += 400;
            else if (currChar == 'C' && nextChat == 'M')
                total += 900;
            else if (currChar == 'C')
                total += 100;

            if (currChar == 'D')
                total += 500;

            if (currChar == 'M')
                total += 1000;
        }

        return total;
    }

}
