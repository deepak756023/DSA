package hash_table;

import java.util.LinkedList;

public class HashMap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    LinkedList<Entry>[] entries = new LinkedList[10];

    //// when the number of entry increases HashMap perfoms well
    // 10 < 100 < 1000 < 10000

    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket)
            if (entry.key == key) {
                entry.value = value;
                return;
            }

        bucket.addLast(new Entry(key, value));

    }

    public String get(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry.value;

        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            throw new IllegalStateException();

        for (var entry : bucket)
            if (entry.key == key)
                bucket.remove(entry);

    }

    private int hash(int key) {
        return key % entries.length;
    }
}
