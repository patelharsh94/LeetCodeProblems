
// #63 Unique Paths II
public class UniquePathWithObstacles {

    public void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("" + grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        printGrid(obstacleGrid);
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
            // iterating through the 0th row
            for (int i = 1; i < obstacleGrid[0].length; i++) {
                if (obstacleGrid[0][i - 1] == 1 && obstacleGrid[0][i] == 0) {
                    obstacleGrid[0][i] = 1;
                } else {
                    obstacleGrid[0][i] = 0;
                }
            }

            // iterating through the 0th column
            for (int i = 1; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0) {
                    obstacleGrid[i][0] = 1;
                } else {
                    obstacleGrid[i][0] = 0;
                }
            }

            printGrid(obstacleGrid);

            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[0].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
            printGrid(obstacleGrid);
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
