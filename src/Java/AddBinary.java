import org.junit.Test;

// 67. Add Binary
public class AddBinary {

    public String addBinary(String a, String b) {

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int dig1 = 0;
        int dig2 = 0;
        int i = a.length()-1;
        int j = b.length()-1;


        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                dig1 = a.charAt(i) - '0';
            } else {
                dig1 = 0;
            }

            if (j >= 0) {
                dig2 = b.charAt(j) - '0';
            } else {
                dig2 = 0;
            }

            if (dig1 + dig2 + carry == 2) {
                sb.insert(0, 0);
                carry = 1;
            } else if (dig1 + dig2 + carry == 3) {
                sb.insert(0, 1);
                carry = 1;
            } else {
                sb.insert(0, dig1 + dig2 + carry);
                carry = 0;
            }

            i--;
            j--;
        }

        if (carry > 0)
            sb.insert(0, carry);

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("0", "0"));
    }

}
