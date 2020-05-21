package Amazon;

import org.junit.Test;

import java.util.*;

public class AmazonQ1 {

    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
    {
        int total = 0;

        if (rows == 0 || column == 0)
            return total;

        for (int i = 0; i < rows; i++) {
            List<Integer> currRow = grid.get(i);
            boolean isStoreCreated = false;
            for (int j = 0; j < column; j++) {

                if (j + 1 < column && (currRow.get(j) == 0 && currRow.get(j+1) == 1)) {
                    total++;
                    currRow.set(j , 1);
                    j++;
                    isStoreCreated = true;
                } else if (j + 1 < column && (currRow.get(j) == 1 && currRow.get(j+1) == 0)) {
                    total++;
                    currRow.set(j + 1, 0);
                    j++;
                    isStoreCreated = true;
                }

                if (isStoreCreated) {
                    while (currRow.get(j) != 0)
                        j++;
                    isStoreCreated = false;
                }
            }
        }

        return total;
    }

    @Test
    public void test1() {

        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(1);
        r1.add(0);
        r1.add(0);

        List<Integer> r2 = new ArrayList<>();
        r2.add(0);
        r2.add(1);
        r2.add(0);
        r2.add(0);

        List<Integer> r3 = new ArrayList<>();
        r3.add(1);
        r3.add(0);
        r3.add(1);
        r3.add(0);

        List<Integer> r4 = new ArrayList<>();
        r4.add(0);
        r4.add(0);
        r4.add(0);
        r4.add(0);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(r1);
        arr.add(r2);
        arr.add(r3);
        arr.add(r4);

        System.out.println(numberAmazonGoStores(4, 4, arr));
    }

    class log {
        String identifier;
        String data;
        boolean isNumeric;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (String str: logLines) {
            if (isLetters(str))
                letters.add(str);
            else
                numbers.add(str);
        }

        letters.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] o1Arr = o1.split(" ");
                String [] o2Arr = o2.split(" ");
                if (o1.equals(o2)) {
                    return o1Arr[0].compareTo(o2Arr[0]);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String str : letters) {
            result.add(str);
        }

        for (String str : numbers) {
            result.add(str);
        }

        return result;
    }

    private boolean isLetters(String str) {
        String [] arr = str.split(" ");
        return arr[1].charAt(0) > 57;
    }

    @Test
    public void test2() {
        List<String> listOfStrings = new ArrayList<>();

    }
}
