package custom_dynamic_array;

public class Array {
    private int[] nums;
    private int count;

    public Array(int length) {
        this.nums = new int[length];
    }

    public void insert(int value) {
        if (nums.length == count)
            resizeNums();

        nums[count] = value;
        count++;
    }

    public void insertAt(int value, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeNums();
        for (int i = count - 1; i >= index; i--)
            nums[i + 1] = nums[i];

        nums[index] = value;
        count++;
    }

    public int max() {
        int max = nums[0];
        for (int i = 0; i < count; i++)
            if (max < nums[i])
                max = nums[i];

        return max;

    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count - 1; i++)
            nums[i] = nums[i + 1];

        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (nums[i] == value)
                return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(nums[i]);

    }

    public void reverse() {
        for (int i = count - 1; i >= 0; i--)
            System.out.println(nums[i]);
    }

    private void resizeNums() {

        int[] copy = new int[count * 2];
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];

        nums = copy;

    }

}
