
// 547. Friend Circles

import org.junit.Test;

import java.util.*;

public class FriendCircle {

    // solution from https://leetcode.com/problems/friend-circles/discuss/101338/Neat-DFS-java-solution

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int [] [] M = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        System.out.println(findCircleNum(M));
    }
}
