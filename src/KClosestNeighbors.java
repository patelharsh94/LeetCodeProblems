import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DistanceNode {

    int []  point;
    double distanceFrom0;

    DistanceNode(int [] point, double distance) {
        this.point = point;
        this.distanceFrom0 = distance;
    }
}

class DistanceComparator implements Comparator<DistanceNode> {

    @Override
    public int compare(DistanceNode o1, DistanceNode o2) {

        double result = o1.distanceFrom0 - o2.distanceFrom0;

        if (result < 0)
            return -1;
        else if (result > 0)
            return 1;
        else
            return 0;

    }
}

public class KClosestNeighbors {

    public int[][] kClosest(int[][] points, int K) {

        List<DistanceNode> distanceList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            distanceList.add(new DistanceNode(points[i], distance));
        }

        Collections.sort(distanceList, new DistanceComparator());

        int [] [] finalList = new int [K][];

        for (int i = 0; i < K; i++) {
            finalList[i] = distanceList.get(i).point;
        }

        return finalList;
    }
}
