package heap;

public class MaxHeap {
    public static void heapify(int[] numbers) {
        int lastParentIndex = (numbers.length / 2) - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(numbers, i);
    }

    public static void heapify(int[] numbers, int index) {
        var largerIndex = index;

        var leftChildIndex = index * 2 + 1;
        if (leftChildIndex < numbers.length && numbers[leftChildIndex] > numbers[largerIndex])
            largerIndex = leftChildIndex;

        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex < numbers.length && numbers[rightChildIndex] > numbers[largerIndex])
            largerIndex = rightChildIndex;

        if (index == largerIndex)
            return;
        swap(numbers, index, largerIndex);

        heapify(numbers, largerIndex);

    }

    private static void swap(int[] numbers, int first, int second) {
        var temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    public static int getKthLargerst(int[] numbers, int k) {
        if (k < 1 || k > numbers.length)
            throw new IllegalArgumentException();
        Heap heap = new Heap();
        for (int i = 0; i < numbers.length; i++)
            heap.insert(numbers[i]);
        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();

    }

}
