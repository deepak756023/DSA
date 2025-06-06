package hash_table;

import java.util.Map;
import java.util.HashMap;

public class HashTableExcercises {

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

}
