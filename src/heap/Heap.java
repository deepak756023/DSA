package heap;

import java.util.Arrays;

public class Heap {
    private int[] numbers = new int[10];
    private int size = 0;

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException("Heap is full");

        numbers[size] = value;
        bubbleUp(size);
        size++;
    }

    public boolean isFull() {
        return size == numbers.length;
    }

    private void bubbleUp(int index) {
        while (index > 0 && numbers[index] > numbers[parent(index)]) {

            swap(index, parent(index));

            index = parent(index);
        }
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = numbers[0];
        numbers[0] = numbers[--size];

        bubbleDown();

        return root;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = findLargerChildIndex(index);
            swap(index, largerChildIndex);

            index = largerChildIndex;

        }
    }

    private int findLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        boolean isValid = numbers[index] >= numbers[leftChildIndex(index)];

        if (hasRightChild(index))
            isValid &= numbers[index] >= numbers[rightChildIndex(index)];

        return isValid;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int leftChild(int index) {
        return numbers[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return numbers[rightChildIndex(index)];
    }

    private void swap(int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, size)));
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();
        return numbers[0];
    }
}
