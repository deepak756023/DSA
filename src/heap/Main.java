package heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        // heap.insert(15);
        // heap.insert(10);
        // heap.insert(3);
        // heap.insert(8);
        // heap.insert(12);
        // heap.insert(9);
        // heap.insert(4);
        // heap.insert(1);
        // heap.insert(24);

        // heap.remove();
        // heap.print();

        int[] numbers = { 5, 3, 10, 1, 4, 2 };
        for (var number : numbers)
            heap.insert(number);

        for (int i = 0; i < numbers.length; i++)// Sorted in DESC Order
            // for (int i = numbers.length - 1; i >= 0; i--) // Sorted in ASC Order
            numbers[i] = heap.remove();

        System.out.println(Arrays.toString(numbers));

        int[] nums = { 15, 10, 3, 8, 12, 9, 4, 1, 24, 80, 50 };
        MaxHeap.heapify(nums);
        System.out.println(Arrays.toString(nums));

    }

}
