package queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedListQueue {

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

    public void enqueue(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        int value = first.value;
        if (first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();

        return first.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
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
