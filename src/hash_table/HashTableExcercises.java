package hash_table;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class HashTableExcercises {

    // A variation of this exercise is finding the most repeated word in a sentence
    public int mostFrequent(int[] numbers) {
        if (numbers.length == 0)
            throw new IllegalStateException();

        Map<Integer, Integer> map = new HashMap<>();
        int count;
        for (var num : numbers) {
            count = map.containsKey(num) ? map.get(num) + 1 : 1;

            map.put(num, count);
        }

        int max = 0;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;

    }

    public int countPairsWithDiff(int[] numbers, int k) {

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < numbers.length; i++)
            set.add(numbers[i]);

        for (var num : numbers) {
            if (set.contains(num + k))
                count++;

            if (set.contains(num - k))
                count++;

            set.remove(num);
        }
        return count;

    }

    public int[] twoSum(int[] numbers, int target) {

        // This problem is a variation of the previous problem
        // (countPairsWithDiff).
        //
        // If a + b = target, then b = target - a.
        //
        // So we iterate our array, and pick (a). Then,
        // we check to see if we have (b) in our array.
        // Similar to the last problem, this would be an O(n^2)
        // operation, because we'll need two nested loops for
        // looking up (b).
        //
        // We can optimize this by using a hash table. In this
        // hash table, we store numbers and their indexes.
        //
        // There is no need to store all the numbers in the hash table
        // first. If we find two numbers that add up to the target,
        // we simply return their indexes.

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        // Time complexity of this method is O(n) because we need to iterate
        // the array only once.

        return null;
    }

}
