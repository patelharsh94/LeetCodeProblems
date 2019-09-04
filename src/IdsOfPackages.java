import java.util.ArrayList;

public class IdsOfPackages {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     ArrayList<Integer> packagesSpace)
    {
        int spaceAvailable = truckSpace - 30;
        int maxFound = 0;
        ArrayList<Integer> ids = new ArrayList<>();
        int index1 = 0, index2 = 0;

        for (int i = 0; i < packagesSpace.size(); i++) {
            for (int j = i; j < packagesSpace.size(); j++) {
                int currMax = packagesSpace.get(i) + packagesSpace.get(j);

                if (currMax <= spaceAvailable && currMax >= maxFound) {
                    maxFound = currMax;
                    index1 = i;
                    index2 = j;
                }
            }
        }

        ids.add(index1);
        ids.add(index2);
        return ids;
    }
}
