package Mocks;

import org.junit.Test;

import java.util.Calendar;
import java.util.PriorityQueue;
import java.util.Queue;

public class Mock15 {

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        String [] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    @Test
    public void test() {
        System.out.println(dayOfTheWeek(18, 7, 1999));
    }
}


class MyQueue {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new PriorityQueue<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}