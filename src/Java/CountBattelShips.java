import org.junit.Test;

public class CountBattelShips {

    // 419. Battleships in a Board
    public int countBattleships(char[][] board) {

        int totalShips = 0;
        boolean isPartOfShip = false;

        if (board != null && board.length > 0 && board[0].length > 0) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {

                    if (board[i][j] == 'X') {

                        // check top
                        if (i > 0) {
                            isPartOfShip = board[i-1][j] == 'X';
                        }

                        // check left
                        if (j > 0 && !isPartOfShip) {
                            isPartOfShip = board[i][j-1] == 'X';
                        }

                        totalShips = !isPartOfShip ? totalShips+1 : totalShips;

                    }

                    isPartOfShip = false;

                }
            }

        }

        return totalShips;
    }

    @Test
    public void test() {
        char [] [] board =
               {{'.','X','X','X','X','.','X','.','X','.'},
                {'X','.','.','.','.','.','.','.','X','.'},
                {'.','X','.','X','.','X','.','.','X','.'},
                {'X','.','X','.','X','.','.','.','X','.'},
                {'.','X','.','X','.','.','X','.','.','X'}};

        System.out.println(countBattleships(board));
    }

}
