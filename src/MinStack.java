import java.util.ArrayList;
import java.util.List;

class StackNode {

    int num;
    int lastMin;

    StackNode(int num, int lastMin) {
        this.num = num;
        this.lastMin = lastMin;
    }
}

public class MinStack {

    int min = Integer.MAX_VALUE;
    List<StackNode> stack = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {

        System.out.println("push --> " + x);
        stack.add(0, new StackNode(x, min));
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        StackNode poppedVal = stack.remove(0);

        if (poppedVal.num == min) {
            min = poppedVal.lastMin;
        }

        System.out.println("pop --> " + poppedVal.num);
        System.out.println("new min --> " + poppedVal.lastMin);
    }

    public int top() {
        int top = stack.get(0).num;
        System.out.println("top --> " + top);
        return top;
    }

    public int getMin() {
        System.out.println("getMin --> " + min);
        return min;
    }
}