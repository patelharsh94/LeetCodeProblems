package Mocks;

import org.junit.Test;

import java.util.*;

public class MockLeetCodeInterview {


    /*
     * You are given a string representing an attendance record for a student. The record only contains the following three characters:
        'A' : Absent.
        'L' : Late.
        'P' : Present.
        A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

        You need to return whether the student could be rewarded according to his attendance record.

        Example 1:
            Input: "PPALLP"
            Output: True
        Example 2:
            Input: "PPALLL"
            Output: False
    * */

    /*
    *
    *   There are N network nodes, labelled 1 to N.

        Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

        Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

        Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
        Output: 2
    */
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N+1];
        int res = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;

    }

    @Test
    public void testNetworkDelayTime() {
        int[][] arr = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(arr, 4, 2));
    }
}
