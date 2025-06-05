package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    // O(1)
    public void push(int item) {
        top = item;
        queue1.add(top);
    }

    // O(n)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        swap();

        return queue2.remove();

    }

    public void swap() {
        var temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    // O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;

    }

    // O(1)
    public int size() {
        return queue1.size();

    }

    // O(1)
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    @Override
    public String toString() {
        return queue1.toString();
    }

}
