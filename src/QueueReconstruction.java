import org.junit.Test;

import java.util.*;


// solution from : https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89350/Java-solution-using-Arrays.sort()-and-%22insert-sorting%22-idea
// 406. Queue Reconstruction by Height
public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {

        if (people != null && people.length > 0 && people[0].length > 0) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (b[0] == a[0]) return a[1] - b[1];
                    return b[0] - a[0];
                }
            });

            int n = people.length;
            ArrayList<int[]> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

            int[][] res = new int[people.length][2];
            int i = 0;
            for (int[] k : tmp) {
                res[i][0] = k[0];
                res[i++][1] = k[1];
            }

            return res;
        }

        return new int [1] [0];

    }

    @Test
    public void test() {
        int [] [] arr = new int [] [] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(arr);
    }

}
