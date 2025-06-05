package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        System.out.println(queue);

    }

    // The reverse method more space-efficient and cleaner than reverseKth,while
    // both correctly reverse the first k elements of the queue in O(n) time.

    public void reverseKthD(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        while (!queue.isEmpty()) {
            if (i < k) {
                stack.push(queue.remove());
                i++;
            }

            else
                list.addLast(queue.remove());
        }
        while (!stack.isEmpty())
            queue.add(stack.pop());
        while (!list.isEmpty())
            queue.add(list.removeFirst());

        System.out.println(queue);

    }

    public void reverseKthM(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.empty())
            queue.add(stack.pop());

        // Add the remaining items in the queue (items
        // after the first K elements) to the back of the
        // queue and remove them from the beginning of the queue
        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());

        System.out.println(queue);

    }
}
