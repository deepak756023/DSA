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
        // // reverseQueue.reverse(queue);
        // reverseQueue.reverseKthM(queue, 4);

        // ArrayQueue queue = new ArrayQueue(5);
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // queue.remove();
        // queue.remove();
        // queue.remove();
        // queue.add(15);
        // queue.add(25);
        // queue.remove();
        // System.out.println(queue);

        LinkedListQueue list = new LinkedListQueue();
        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(70);
        list.enqueue(50);
        list.dequeue();
        System.out.println(list.size());

        System.out.println(list.toString());
    }

}
