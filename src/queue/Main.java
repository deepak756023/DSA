package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // ReverseQueue reverseQueue = new ReverseQueue();
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // System.out.println(queue);
        // reverseQueue.reverse(queue);

        ArrayQueue queue = new ArrayQueue(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(15);
        queue.add(25);
        queue.remove();
        System.out.println(queue);
    }

}
