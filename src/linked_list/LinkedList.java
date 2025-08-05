package linked_list;

import java.util.NoSuchElementException;

public class LinkedList {

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

    private Boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        var node = new Node(value);

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        var current = first;
        for (int i = 0; i < index - 1; i++)
            current = current.next;

        node.next = current.next;
        current.next = node;
        size++;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();

        }
        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();

        }
        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;

    }

    public void remove(int val) {
        
    }

    public void removeAt(int index) {
        if (isEmpty())
            throw new NoSuchElementException();

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        var previous = first;
        for (int i = 0; i < index - 1; i++)
            previous = previous.next;

        var target = previous.next;
        previous.next = target.next;
        target.next = null; // Help GC

        size--;
    }

    private Node getPrevious(Node last) {
        var current = first;
        while (current != null) {
            if (current.next == last)
                return current;

            current = current.next;
        }
        return null;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void clear() {
        var current = first;
        while (current != null) {
            var next = current.next;
            current.next = null; // Disconnect node
            current = next;
        }

        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }

    public int findKthNodeFromTheEnd(int k) {
        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            if (b.next == null) {
                throw new IllegalStateException();
            }
            b = b.next;
        }
        while (b.next != null) {
            b = b.next;
            a = a.next;
        }
        return a.value;

    }

    public void findMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        while (b.next != null && b.next.next != null) {
            // while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + ", " + a.next.value);
        }
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
}
