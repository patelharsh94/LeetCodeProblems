package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock25 {

    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }

    @Test
    public void test() {
        System.out.println(isPowerOfFour(8));
    }


    public int[] exclusiveTime(int n, List<String> logs) {

        int [] exclusiveTime = new int [n];

        for (int i = 1; i < logs.size(); i++) {
            String currFun = logs.get(i);

            int currIndex = Integer.valueOf(currFun.substring(0, 1));
            boolean isStart = currFun.contains("start");
            int currVal = Integer.valueOf(currFun.substring(currFun.length()-1));

            String prevFun = logs.get(i-1);
            int prevIndex = Integer.valueOf(prevFun.substring(0, 1));
            boolean prevIsStart = prevFun.contains("start");
            int prevVal = Integer.valueOf(prevFun.substring(prevFun.length()-1));

            int diff = currVal - prevVal;

            if (isStart && prevIsStart && currVal != prevVal) {
                exclusiveTime[prevIndex] += diff;
            }

            if (isStart && !prevIsStart) {
                exclusiveTime[prevIndex] += diff;
            }

            if (!isStart && prevIsStart) {
                exclusiveTime[currIndex] += diff+1;
            }

            if (!isStart && !prevIsStart) {
                exclusiveTime[currIndex] += diff;
            }

        }

        return exclusiveTime;
    }

    public int[] exclusiveTimeSOLVED(int n, List < String > logs) {
        Stack < Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }

    @Test
    public void test2() {

        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:7");
        logs.add("1:end:7");
        logs.add("0:end:8");

        exclusiveTimeSOLVED(2, logs);
    }
}
