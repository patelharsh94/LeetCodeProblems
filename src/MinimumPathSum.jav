// 64. Minimum Path Sum
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int addTop = Integer.MAX_VALUE, addLeft = Integer.MAX_VALUE;
                    if (i > 0) {
                        addTop = grid[i][j] + grid[i-1][j];
                    }
                    if (j > 0) {
                        addLeft = grid[i][j] + grid[i][j-1];
                    }

                    if (addLeft != Integer.MAX_VALUE || addTop != Integer.MAX_VALUE) {
                        if (addTop < addLeft) {
                            grid[i][j] = addTop;
                        } else {
                            grid[i][j] = addLeft;
                        }
                    }

                }
            }

            return grid[grid.length-1][grid[0].length-1];
    }
}
