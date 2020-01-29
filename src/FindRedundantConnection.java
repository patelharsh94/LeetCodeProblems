
class Edge {
    int incomingNum;
    int outgoingNum;

    Edge() {
        incomingNum = 0;
        outgoingNum = 0;
    }
}

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        Edge [] edgeCounts = new Edge [edges.length];
        int [] result = new int [2];
        int outgoingNum, incomingNum;

        for (int i = 0; i < edgeCounts.length; i++) {
            edgeCounts[i] = new Edge();
        }

        for (int i = 0; i < edges.length; i++) {
            outgoingNum = edges[i][0]-1;
            incomingNum = edges[i][1]-1;

            edgeCounts[outgoingNum].outgoingNum++;
            edgeCounts[incomingNum].incomingNum++;
        }

        for (int i = 0; i < edgeCounts.length; i++) {
            if (edgeCounts[i].outgoingNum > 2) {
                result[0] = i+1;
            }

            if (edgeCounts[i].incomingNum > 1) {
                result[1] = i+1;
            }
        }

        return result;
    }
}
