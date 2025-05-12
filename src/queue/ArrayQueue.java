package queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] array;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
    }

    public void add(int value) {

        array[rear] = value;
        rear = (rear + 1) % array.length;

    }

    public int remove() {
        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        return item;

    }

    public Boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    // public void print() {
    // int[] copy = {};
    // if (front == -1) {
    // System.out.println(Arrays.toString(copy));
    // } else {
    // copy = Arrays.copyOfRange(array, front, rear + 1);
    // System.out.println(Arrays.toString(copy));
    // }

    // }
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
