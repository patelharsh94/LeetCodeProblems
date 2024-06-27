package Mocks;


import org.junit.Test;

import java.util.*;

public class Mock14 {

    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalid = new ArrayList<>();
        HashMap<String, List<String []>> trans = new HashMap<>();

        for (String arr : transactions) {
            String [] currTrans = arr.split(",");
            ArrayList<String []> currTransList = new ArrayList<>();
            if (Integer.valueOf(currTrans[2]) > 1000) {
                invalid.add(arr);
            } else {
                List<String []> transByUser = trans.get(currTrans[0]);

                if (transByUser != null) {
                    for (String [] userTans : transByUser) {
                        if (Math.abs(Integer.valueOf(userTans[1]) - Integer.valueOf(currTrans[1])) <= 60 &&
                                !userTans[3].equals(currTrans[3])) {
                            StringBuilder sb = new StringBuilder();

                            for (String s : userTans)
                                sb.append(s).append(",");

                            sb.deleteCharAt(sb.length()-1);
                            invalid.add(sb.toString());
                            invalid.add(arr);
                        }
                    }
                    transByUser.add(currTrans);
                    trans.put(currTrans[0], transByUser);
                } else {
                    currTransList.add(currTrans);
                    trans.put(currTrans[0], currTransList);
                }
            }
        }
        return invalid;
    }

    @Test
    public void test() {
        String [] arr = {"alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(invalidTransactions(arr));
    }
}
