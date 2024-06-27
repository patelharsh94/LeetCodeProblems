package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock35 {

    public String reverseStr(String s, int k) {

        StringBuilder sb = new StringBuilder(s);

        if (s.length() == 1) {
            return s;
        }

        if (s.length() <= k) {
            return sb.reverse().toString();
        }

        if (s.length() <= 2 * k) {
            return sb.replace(0, k, new StringBuilder(sb.substring(0, k)).reverse().toString()).toString();
        }

        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k < s.length()) {
                sb.replace(i, i + k, new StringBuilder(sb.substring(i, i + k)).reverse().toString());
            } else {
                sb.replace(i, s.length(), new StringBuilder(sb.substring(i, s.length())).reverse().toString());
            }
        }

        return sb.toString();
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        List<List<Integer>> finalResult = new ArrayList<>();

        for (int i = 0; i < connections.size(); i++) {
            int key = connections.get(i).get(0);
            int val = connections.get(i).get(1);
            List<Integer> valList = adjList.get(key);
            if (valList == null) {
                valList = new ArrayList<>();
                valList.add(val);
            } else {
                valList.add(val);
            }
            adjList.put(key, valList);
            valList = adjList.get(val);
            if (valList == null) {
                valList = new ArrayList<>();
                valList.add(key);
            } else {
                valList.add(key);
            }
            adjList.put(val, valList);
        }

        List<Integer> keyMemo = new ArrayList<>();

        for (int key : adjList.keySet()) {

            if (adjList.get(key).size() == 1 && !keyMemo.contains(adjList.get(key).get(0))) {
                List<Integer> criticalConnection = new ArrayList<>();
                criticalConnection.add(key);
                criticalConnection.add(adjList.get(key).get(0));
                finalResult.add(criticalConnection);
                keyMemo.add(key);
            }
        }

        return finalResult;

    }

    @Test
    public void test() {
        List<List<Integer>> test = new ArrayList<>();
        int [] [] arr  = {{0,1},{1,2},{2,0},{1,3},{3,4},{4,5},{5,3}};

        for (int i = 0; i < arr.length; i++) {
            List<Integer> conn = new ArrayList<>();
            conn.add(arr[i][0]);
            conn.add(arr[i][1]);
            test.add(conn);
        }

        criticalConnections(4, test);
    }

    public int minReorder(int n, int[][] connections) {
        int total = 0;
        int [] visited = new int [n];

        for (int i = 0; i < n-1; i++) {
            int pointA = connections[i][0];
            int pointB = connections[i][1];

            if (pointA == 0) {
                total++;
                visited[pointA] = 1;
                visited[pointB] = 1;

            } else if (visited[pointA] == 0 && visited[pointB] == 1)  {
                total++;
            }
        }

        return total;
    }

}
