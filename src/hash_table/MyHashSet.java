package hash_table;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {
    private static class Entry {
        int key;

        Entry(int key) {
            this.key = key;
        }
    }

    // test

    LinkedList<Entry>[] entries = new LinkedList[1000];

    public void add(int key) {
        int index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket)
            if (entry.key == key) {
                return;
            }

        bucket.addLast(new Entry(key));

    }

    public void remove(int key) {
        int index = hash(key);
        var bucket = entries[index];

        if (bucket == null)
            return;

        Iterator<Entry> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove();
                return;
            }
        }

    }

    public boolean contains(int key) {
        int index = hash(key);
        var bucket = entries[index];

        if (bucket == null)
            return false;

        for (var entry : bucket)
            if (entry.key == key)
                return true;

        return false;

    }

    public int hash(int key) {
        return key % entries.length;
    }
}
