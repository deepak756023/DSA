package hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindChar {

    public char findFirstNonRepeatChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();

        for (var ch : charArray) {
            var count = map.containsKey(ch) ? map.get(ch) + 1 : 1;
            map.put(ch, count);
        }
        for (var ch : charArray) {
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatChar(String str) {
        Set<Character> set = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);

        }
        return Character.MIN_VALUE;

    }

}
