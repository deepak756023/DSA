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

}
