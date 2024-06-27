public class ValidUTF8 {
    public boolean validUtf8(int[] data) {

        StringBuilder byteStringBuilder = new StringBuilder();

        for (int val : data) {
            String binaryNum = Integer.toBinaryString(val);

            if (data[0] != val && binaryNum.length() < 8) {
                for (int a = 0; a < 8-binaryNum.length(); a++)
                    byteStringBuilder.append('0');
            }
            byteStringBuilder.append(binaryNum);
        }

        String byteString = byteStringBuilder.toString();

        if (byteString.charAt(0) == 0) {
            return true;
        } else {

            int n = 0;
            int i = 0;
            int pointer = 0;
            int significant = 0;

            while (n < byteString.length() - 1 && byteString.charAt(n) == '1') {
                n++;
            }

            if (n+1 < byteString.length() - 1 && byteString.charAt(n) != '0') {
                return false;
            }

            i = n+1;

            while (i < byteString.length() - 2) {
                if (i % 8 == 0 && byteString.charAt(i) == '1' && byteString.charAt(i+1) == '0') {
                    significant++;
                }
                i++;
            }

            if (significant != n-1)
                return false;
        }
        return true;
    }
}
