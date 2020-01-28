import java.util.ArrayList;
import java.util.List;

// 225. Implement Stack using Queues
public class Stack {
    List<Integer> stack = new ArrayList<Integer>();

    /** Initialize your data structure here. */
    public Stack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(0, x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.remove(0);
    }

    /** Get the top element. */
    public int top() {
        return stack.get(0);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }
}

