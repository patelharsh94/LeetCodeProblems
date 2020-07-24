import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FreqStack {

    HashMap<Integer, Integer> maxHeap;

    public FreqStack() {
        maxHeap = new HashMap<>();
    }

    public void push(int x) {

        if (maxHeap.containsKey(x)) {
            int val = maxHeap.get(x);
            maxHeap.put(x, val+1);
        } else {
            maxHeap.put(x, 1);
        }
    }

    public int pop() {

        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger maxKey = new AtomicInteger();
        maxHeap.forEach((k,v) -> {
            if (v > max.get()) {
                max.set(v);
                maxKey.set(k);
            }
        });

        maxHeap.put(maxKey.get(), max.get()-1);

        return maxKey.get();
    }

    @Test
    public void test() {
        push(5);
        push(7);
        push(5);
        push(7);
        push(4);
        push(5);

        pop();
        pop();
        pop();
        pop();
    }

}

