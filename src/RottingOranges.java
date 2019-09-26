import java.util.ArrayDeque;
import java.util.Queue;

// 994. Rotting Oranges
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int totalMoves = 0;
        Queue<int []> orangeQueue = new ArrayDeque<>();
        int freshOranges = 0;
        int [][] checks = new int[][]{ {-1,0}, {0, -1}, {1,0}, {0,1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1)
                    freshOranges++;
                if (grid[i][j] == 2)
                    orangeQueue.add(new int[] {i,j});
            }
        }


        if (freshOranges == 0)
            return 0;

        while (!orangeQueue.isEmpty()) {
            totalMoves++;
            int size = orangeQueue.size();
            for (int i = 0; i < size; i++) {
                int [] rottenLocation = orangeQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = rottenLocation[0] + checks[j][0];
                    int y = rottenLocation[1] + checks[j][1];

                    if (x >= 0 && x < grid.length && y < grid[0].length && y >= 0 && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;

                        if (freshOranges == 0) {
                            return totalMoves;
                        }

                        orangeQueue.add(new int [] {x,y});
                    }
                }
            }
        }

        return freshOranges > 0 ? -1 : totalMoves;
    }

//    public int orangesRotting(int[][] grid) {
//
//        int totalMoves = 0;
//        boolean didRot = false;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//
//                if (grid[i][j] == 2) {
//
//                    if (i + 1 < grid.length && grid[i+1][j] == 1) {
//                        grid[i+1][j] = 2;
//                        didRot = true;
//                    }
//
//                    if (i - 1 >= 0 && grid[i-1][j] == 1) {
//                        grid[i-1][j] = 2;
//                        didRot = true;
//                    }
//
//                    if (j + 1 < grid[i].length && grid[i][j+1] == 1) {
//                        grid[i][j+1] = 2;
//                        didRot = true;
//                    }
//
//                    if (j - 1 >= 0 && grid[i][j-1] == 1) {
//                        grid[i][j-1] = 2;
//                        didRot = true;
//                    }
//
//                    if (grid[i][j] == 1 && !didRot && !shouldRot(grid, i, j))
//                        return -1;
//
//                    if (didRot) {
//                        totalMoves++;
//                        didRot = false;
//                    }
//                }
//
//            }
//
//            for (int j = 0; j < grid[i].length; j++) {
//
//                if (grid[i][j] == 1 && shouldRot(grid, i, j)) {
//                    totalMoves++;
//                }
//            }
//        }
//
//        if (totalMoves == 0)
//            totalMoves = -1;
//
//        return totalMoves;
//    }

}

