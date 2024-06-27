public class NumberOfEnclaves {

    public int checkSides(int [] [] A, int x, int y) {

        int total = 0;

        // check up
        for (int i = y; i >= 0; i--) {
            if (A[i][x] == 1)
                total = 1;

            if (A[i][x] == 0) {
                total = 0;
                break;
            }
        }

        if (total == 1)
            return total;
        // check down

        for (int i = y; i < A.length; i++) {
            if (A[i][x] == 1)
                total = 1;

            if (A[i][x] == 0) {
                total = 0;
                break;
            }
        }

        if (total == 1)
            return total;

        // check right
        for (int i = x; i < A[y].length; i++) {
            if (A[y][i] == 1)
                total = 1;

            if (A[y][i] == 0) {
                total = 0;
                break;
            }
        }

        if (total == 1)
            return total;


        // check left
        for (int i = x; i >= 0; i--) {
            if (A[y][i] == 1)
                total = 1;

            if (A[y][i] == 0) {
                total = 0;
                break;
            }
        }

        return total;
    }

    public int numEnclaves(int[][] A) {

        int numberOfOnes = 0;
        int numberEscape = 0;


        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1)
                {
                    numberEscape += checkSides(A, j, i);
                    numberOfOnes++;
                }
            }
        }

        return numberOfOnes - numberEscape;
    }
}
