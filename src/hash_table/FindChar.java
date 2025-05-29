package hash_table;

import java.util.HashMap;
import java.util.Map;

public class FindChar {

    public char findFirstNonRepeatChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (var ch : charArray) {
            var count = map.containsKey(ch) ? map.get(ch) + 1 : 1;
            map.put(ch, count);

            // if (map.containsKey(ch)) {
            // var count = map.get(ch);
            // map.put(ch, count + 1);

            // } else
            // map.put(ch, 1);
        }
        System.out.println(map);
        for (var ch : charArray) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

}
