import java.util.TreeMap;

// 1146. Snapshot Array
// taken from: https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
public class SnapshotArray {

    TreeMap<Integer, Integer> [] dataTreeArr;
    int snapId = 0;

    public SnapshotArray(int length) {
        dataTreeArr = new TreeMap [length];

        for (int i = 0; i < length; i++) {
            dataTreeArr[i] = new TreeMap<>();
            dataTreeArr[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        dataTreeArr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return  dataTreeArr[index].floorEntry(snap_id).getValue();
    }

}
