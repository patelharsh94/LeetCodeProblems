public class KthGrammer {

    public int kthGrammar(int N, int K) {
        N--; K--;
        boolean isOdd = false;

        while (N > 0) {
            isOdd = (K % 2 == 0) == isOdd;
            K /= 2;
            N--;
        }

        return isOdd ? 1 : 0;
    }


}
