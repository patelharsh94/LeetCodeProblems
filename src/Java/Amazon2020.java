import java.util.*;

public class Amazon2020 {

    /*
    *
    * */

    public static long getSongPairCount(List<Integer> songs) {

        if (songs.size() < 2)
            return 0L;

        long numOfPairs = 0;

        for (int i = 0; i < songs.size(); i++) {

            for (int j = i+1; j < songs.size(); j++) {

                if ((songs.get(i) + songs.get(j)) % 60 == 0) {
                    numOfPairs++;
                }

            }

        }
        return numOfPairs;
    }

}
