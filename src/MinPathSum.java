import java.util.PriorityQueue;
import java.util.Queue;

public class MinPathSum {

    class Index {
        int x;
        int y;

        Index(int x, int y) {
            this.x  = x;
            this.y = y;
        }
    }

    public int minPathSum(int[][] grid) {

        Queue<Index> visitedQueue = new PriorityQueue<>();

        int i = 0;
        int j = 0;
        int total = grid[0][0];

        visitedQueue.add(new Index(0,0));

        while (!visitedQueue.isEmpty()) {

            Index currIndex = visitedQueue.poll();

            i = currIndex.x;
            j = currIndex.y;
            int rightX = 0 , rightY = 0;
            int downX = 0, downY = 0;

            int right = 0, down = 0;

            if (i + 1 < grid.length) {
                downX = i+1;
                downY = j;
                down = grid[i][j];
            }

            if (j + 1 < grid[0].length) {
                rightX = i;
                rightY = j+1;
                right = grid[i][j];
            }

            if (right < down) {
                total += grid[rightX][rightY];
                visitedQueue.add(new Index(rightX, rightY));
            } else {
                total += grid[downX][downY];
                visitedQueue.add(new Index(downX, downY));
            }

            if (i == (grid.length - 1) && j == (grid[0].length - 1)) {
                break;
            }
        }

        return total;
    }
}
