public class KthGrammer {

    public String getBinaryOpposite(String curr) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == '0')
                sb.append(1);
            else
                sb.append(0);
        }

        return sb.toString();
    }

    public int kthGrammar(int N, int K) {

        if (N == 0) {
            return 0;
        }

        StringBuilder sbFinal = new StringBuilder("01");

        for (int i = 0; i < N/2; i++) {
            sbFinal.append(getBinaryOpposite(sbFinal.toString()));
            System.out.println(sbFinal.toString());
        }

        return sbFinal.charAt(K-1) - 48;
    }


}
