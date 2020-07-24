import org.junit.Test;

import java.util.Arrays;

// 621. Task Scheduler
public class LeastInterval {

    // taken from : https://leetcode.com/problems/task-scheduler/solution/
    // number 3

    public int leastInterval(char[] tasks, int n) {

        int [] maxChars = new int [26];

        for (int i = 0; i < tasks.length; i++) {
            maxChars[tasks[i]-'A']++;
        }

        Arrays.sort(maxChars);

        int maxValOfChar = maxChars[25]-1;

        int idle = maxValOfChar * n;

        for (int i = 24; i >= 0; i--) {
             idle -= Math.min(maxValOfChar, maxChars[i]);
        }

        return idle > 0 ? tasks.length + idle : tasks.length;
    }

    @Test
    public void test() {
        char [] tasks = new char [] {'A','A','A','B','B','B'};
        leastInterval(tasks, 2);
    }
}
