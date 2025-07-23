package stack;

import java.util.Arrays;

public class CustomStack {
    private int[] nums = new int[5];
    private int count;

    public void push(int value) {
        if (count >= nums.length)
            resizeStack();

        nums[count] = value;
        count++;
    }

    private void resizeStack() {
        int[] copy = new int[count * 2];
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];

        nums = copy;
    }

    public Boolean isEmpty() {
        if (count == 0)
            return true;
        return false;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int item = nums[count - 1];
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return nums[count - 1];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(nums, 0, count);
        return Arrays.toString(content);
    }

}
