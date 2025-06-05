package queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedListQueue {
    // LinkedList<Integer> list = new LinkedList<>();

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // O(1)
    public void enqueue(int value) {
        // list.addLast(item);
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // O(1)
    public int dequeue() {
        // return list.removeFirst();
        if (isEmpty())
            throw new NoSuchElementException();

        var front = first;
        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
        return front.value;
    }

    // )(1)
    public int peek() {
        // return list.getFirst();
        if (isEmpty())
            throw new NoSuchElementException();

        return first.value;
    }

    // )(1)
    public int size() {
        // return list.size();
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        // return list.isEmpty();
        return first == null;
    }

    // O(n)
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();

        Node current = first;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }
}
