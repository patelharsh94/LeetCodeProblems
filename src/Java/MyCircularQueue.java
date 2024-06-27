import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MyCircularQueue {

    List<Integer> queue;
    int maxQueueSize;
    int queueSize = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new ArrayList<>();
        maxQueueSize = k;
        queueSize = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if (queueSize < maxQueueSize) {
            queue.add(value);
            queueSize++;
            return true;
        } else
            return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        try {
            queue.remove(0);
            queueSize--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        try {
            return queue.get(0);
        } catch (Exception e) {
            return -1;
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        try {
            return queue.get(queue.size()-1);
        } catch (Exception e) {
            return -1;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queue.size() == maxQueueSize;
    }
}
